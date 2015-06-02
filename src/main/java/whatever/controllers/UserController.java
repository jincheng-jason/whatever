package whatever.controllers;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whatever.models.CloudUser;
import whatever.models.User;
import whatever.services.CloudService;
import whatever.services.UserService;

import java.io.IOException;


/**
 * Created by lijc on 15/4/4.
 */
@Api(basePath = "/user", value = "user", description = "用户", produces = "application/json",position = 1)
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private CloudService cloudService;

    @Monitored
    @RequestMapping(value = "/findByPhoneNum/{phoneNum}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "通过电话号码查询用户信息", response = User.class)
    public
    @ResponseBody
    User findByPhoneNum(@PathVariable String phoneNum) {
        return userService.findByPhoneNum(phoneNum);
    }

    @Monitored
    @RequestMapping(value = "/requestSmsCode/{phoneNum}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "请求发送手机短信验证码")
    public
    @ResponseBody
    void requestSmsCode(@PathVariable String phoneNum) {
        try {
            cloudService.requestSmsCode(phoneNum);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Monitored
    @RequestMapping(value = "/usersByMobilePhone/{verifyCode}", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "通过手机验证码一键注册或登录，返回id>0为成功")
    public
    @ResponseBody
    User usersByMobilePhone(@RequestBody User user, @PathVariable String verifyCode) {
        String phoneNum = user.getPhoneNum();
        CloudUser cloudUser = null;
        User outputUser = userService.findByPhoneNum(phoneNum);
        //以验证码为初始密码
        user.setPassword(verifyCode);
        if (outputUser == null)
            outputUser = userService.save(user);
        try {
            cloudUser = cloudService.usersByMobilePhone(verifyCode,phoneNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
        outputUser.setCloudId(cloudUser.getObjectId());
        userService.update(outputUser);
        return outputUser;
    }

    /**
     * 用户登录,包括：手机号登录、微博联合登录、微信联合登录
     *
     * @param user
     * @return
     */
    @Monitored
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "手机号密码登录，返回id>0为成功", response = User.class)
    public
    @ResponseBody
    User check(@RequestBody User user) {

        if (!"".equals(user.getPhoneNum()) && null != user.getPhoneNum()) {
            //否则，用手机号登录
            log.info("check by phoneNum:{}", user.getPhoneNum());
            User checkUser = userService.findByPhoneNum(user.getPhoneNum());
            if (null != checkUser && user.getPassword().equals(checkUser.getPassword()))
                return checkUser;
        }
        return user;
    }

    /**
     * 用户新增
     *
     * @param user
     * @return
     */
    @Monitored
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "用户新增，返回id>0为成功", response = User.class)
    public
    @ResponseBody
    User create(@RequestBody User user) {
        try {
            //如果手机号码不为空，则同步leancloud
            if (!"".equals(user.getPhoneNum()) && null != user.getPhoneNum()) {
                user = userService.save(user);
                CloudUser cloudUser = cloudService.userCreate(user);
                user.setCloudId(cloudUser.getObjectId());
                user = userService.update(user);
                log.info("user update:{}", user.getPhoneNum());
            }else if ((!"".equals(user.getWeibo()) && null != user.getWeibo()) || (!"".equals(user.getWeixin()) && null != user.getWeixin())){
                //如果手机号码为空，则保存微博号或微信号
                Iterable<User> weiboUsers = userService.findByWeibo(user.getWeibo());
                Iterable<User> weixinUsers = userService.findByWeixin(user.getWeixin());
                if (weiboUsers.iterator().hasNext()){
                    user = weiboUsers.iterator().next();
                }else if (weixinUsers.iterator().hasNext()){
                    user = weixinUsers.iterator().next();
                }else {
                    user = userService.save(user);
                }
            }
            return user;
        } catch (Exception ex) {
            log.error(ex.toString());
            ex.printStackTrace();
            return user;
        }

    }

    /**
     * 用户信息更新
     *
     * @param user
     * @return
     */
    @Monitored
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "用户信息更新，返回id>0为成功", response = User.class)
    public
    @ResponseBody
    User update(@RequestBody User user) {
        try {
            user = userService.update(user);
            return user;
        } catch (Exception ex) {
            log.error(ex.toString());
            return user;
        }

    }




}

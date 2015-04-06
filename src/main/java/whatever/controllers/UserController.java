package whatever.controllers;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whatever.models.User;
import whatever.services.UserService;
import whatever.utils.Utils;

import java.util.List;


/**
 * Created by lijc on 15/4/4.
 */
@Api(basePath = "/user", value = "user", description = "用户", produces = "application/json")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * test
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Say Hello To World using Swagger")
    public @ResponseBody List<Object> hello(){
        return Utils.returnSuccess("Hello");
    }

    /**
     * 用户登录,包括：手机号登录、微博联合登录、微信联合登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "用户登录,包括：手机号登录、微博联合登录、微信联合登录")
    public @ResponseBody
    List<Object> check(@RequestBody User user){

        if (!"".equals(user.getWeixin()) && null != user.getWeixin()){
            //如果微信号不为空，微信号联合登录

        }else if (!"".equals(user.getWeibo()) && null != user.getWeibo()){
            //微博号不为空，则微博联合登录

        }else if (!"".equals(user.getPhoneNum()) && null != user.getPhoneNum()){
            //否则，用手机号登录
            User checkUser = userService.findByPhoneNum(user.getPhoneNum());
            if (user.getPassword().equals(checkUser.getPassword()))
                return Utils.returnSuccess(checkUser);
            else
                return Utils.returnFailed(user);
        }else{
            //参数为空

        }
        return Utils.returnFailed(user);
    }

    /**
     * 用户新增
      * @param user
     * @return
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "用户新增")
    public @ResponseBody
    List<Object> create(@RequestBody User user){
        try {
            if (!"".equals(user.getPhoneNum()) && null != user.getPhoneNum()){
                userService.save(user);
                return Utils.returnSuccess(user);
            }else{
                return Utils.returnFailed(user);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return Utils.returnFailed(user);
        }

    }

    /**
     * 用户信息更新
     * @param user
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "用户信息更新")
    public @ResponseBody List<Object> accountBind(@RequestBody User user){
        try {
            if (!"".equals(user.getId()) && null != user.getId()){
                user = userService.update(user);
            }else{
                return Utils.returnFailed(user);
            }
            return Utils.returnSuccess(user);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return Utils.returnFailed(user);
        }

    }
}

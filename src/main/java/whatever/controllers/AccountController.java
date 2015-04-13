package whatever.controllers;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whatever.models.Account;
import whatever.services.AccountService;

/**
 * Created by lijc on 15/4/7.
 */
@Api(basePath = "/account", value = "account", description = "公众账号", produces = "application/json")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * 通过account对象查找公众号信息
     *
     * @param account
     * @return
     */
    @Monitored
    @ApiOperation(httpMethod = "POST", value = "通过account对象查找公众号信息", response = Account.class)
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public
    @ResponseBody
    Account find(@RequestBody Account account) {
        if (account.getId() > 0) {
            account = accountService.findById(account.getId());
        } else if (null != account.getAccountName() && !"".equals(account.getAccountName())) {
            account = accountService.findByAccountName(account.getAccountName());
        } else if (null != account.getAccount() && !"".equals(account.getAccount())) {
            account = accountService.findByAccount(account.getAccount());
        } else if (null != account.getOpenId() && !"".equals(account.getOpenId())) {
            account = accountService.findByOpenId(account.getOpenId());
        }
        return account;
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "获取所有公众号信息")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public
    @ResponseBody
    Iterable<Account> findAll() {
        return accountService.findAll();
    }

//    @RequestMapping(value = "/findByAccountName/{accountName}", method = RequestMethod.GET)
//    @ApiOperation(httpMethod = "GET", value = "通过微信公众号名称查找公众号信息")
//    public @ResponseBody Account findByAccountName(@PathVariable String accountName){
//        Account account = accountService.findByAccountName(accountName);
//        return account;
//    }
//
//    @RequestMapping(value = "/findByAccount/{account}", method = RequestMethod.GET)
//    @ApiOperation(httpMethod = "GET", value = "通过微信公众号查找公众号信息")
//    public @ResponseBody Account findByAccount(@PathVariable String account){
//        Account item = accountService.findByAccount(account);
//        return item;
//    }

//    @RequestMapping(value = "/updateAccount", method = RequestMethod.GET)
//    public @ResponseBody
//    Map<String,String> updateAccount(){
//        accountService.updateAccountAndArticle();
//        return new HashMap<>();
//    }

}

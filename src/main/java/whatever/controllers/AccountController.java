package whatever.controllers;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
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


    @RequestMapping(value = "/findByAccountName/{accountName}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "通过微信公众号名称查找公众号信息")
    public @ResponseBody Account findByAccountName(@PathVariable String accountName){
        Account account = accountService.findByAccountName(accountName);
        return account;
    }

    @RequestMapping(value = "/findByAccount/{account}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "通过微信公众号查找公众号信息")
    public @ResponseBody Account findByAccount(@PathVariable String account){
        Account item = accountService.findByAccount(account);
        return item;
    }

}

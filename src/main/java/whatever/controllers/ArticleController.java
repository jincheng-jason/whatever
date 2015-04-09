package whatever.controllers;

import com.wordnik.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lijc on 15/4/7.
 */
@Api(basePath = "/article", value = "article", description = "公众号文章", produces = "application/json")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @RequestMapping("/")
    public @ResponseBody
    String hello(){
        return "Hello article";
    }



}

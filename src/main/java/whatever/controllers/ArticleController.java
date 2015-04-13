package whatever.controllers;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import whatever.models.Article;
import whatever.services.ArticleService;

/**
 * Created by lijc on 15/4/7.
 */
@Api(basePath = "/article", value = "article", description = "公众号文章", produces = "application/json")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "根据文章id获取文章", response = Article.class)
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Article findById(@PathVariable long id) {
        return articleService.findById(id);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "根据文章类别获取文章列表")
    @RequestMapping(value = "/findByCategoryId/{category_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Iterable<Article> findByCategoryId(@PathVariable long category_id) {
        return articleService.findByCategoryId(category_id);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "根据文章类别分页获取文章列表")
    @RequestMapping(value = "/findByCategoryIdPaged/{category_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Article> findByCategoryIdPaged(@PathVariable long category_id, @RequestParam(value = "page", required = true) int page_num, @RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(page_num - 1, page_size, Sort.Direction.DESC, "createTime");
        return articleService.findByCategoryIdPaged(category_id, pageable);
    }

}
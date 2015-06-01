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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lijc on 15/4/7.
 */
@Api(basePath = "/article", value = "article", description = "公众号文章", produces = "application/json",position = 4)
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
    @ApiOperation(httpMethod = "GET", value = "根据公众号ID获取文章列表")
    @RequestMapping(value = "/findByAccountId/{account_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Iterable<Article> findByAccountId(@PathVariable long account_id, @RequestParam(value = "page", required = true) int page_num, @RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(page_num - 1, page_size, Sort.Direction.DESC, "pubDate");
        return articleService.findByAccountIdPaged(account_id, pageable);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "根据公众号ID分页获取比输入时间更新的文章列表")
    @RequestMapping(value = "/findNewerByAccountIdPaged/{account_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Article> findNewerByAccountIdPaged(@PathVariable long account_id,@RequestParam(value = "date", required = true)String date,  @RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "pubDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return articleService.findNewerByAccountIdPaged(account_id, inputDate, pageable);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "根据公众号ID分页获取比输入时间更旧的文章列表，不包括输入时间")
    @RequestMapping(value = "/findOlderByAccountIdPaged/{account_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Article> findOlderByAccountIdPaged(@PathVariable long account_id,@RequestParam(value = "date", required = true)String date, @RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "pubDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return articleService.findOlderByAccountIdPaged(account_id, inputDate, pageable);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "根据公众号ID分页获取比输入时间更旧的文章列表，包括输入时间")
    @RequestMapping(value = "/findInitByAccountIdPaged/{account_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Article> findInitByAccountIdPaged(@PathVariable long account_id,@RequestParam(value = "date", required = true)String date, @RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "pubDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return articleService.findInitByAccountIdPaged(account_id, inputDate, pageable);
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
        Pageable pageable = new PageRequest(page_num - 1, page_size, Sort.Direction.DESC, "pubDate");
        return articleService.findByCategoryIdPaged(category_id, pageable);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "根据文章类别分页获取比输入时间更新的文章列表")
    @RequestMapping(value = "/findNewerByCategoryIdPaged/{category_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Article> findNewerByCategoryIdPaged(@PathVariable long category_id,@RequestParam(value = "date", required = true)String date,  @RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "pubDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return articleService.findNewerByCategoryIdPaged(category_id,inputDate, pageable);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "根据文章类别分页获取比输入时间更旧的文章列表，不包括输入时间")
    @RequestMapping(value = "/findOlderByCategoryIdPaged/{category_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Article> findOlderByCategoryIdPaged(@PathVariable long category_id,@RequestParam(value = "date", required = true)String date, @RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "pubDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return articleService.findOlderByCategoryIdPaged(category_id, inputDate, pageable);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "根据文章类别分页获取比输入时间更旧的文章列表,包括输入时间")
    @RequestMapping(value = "/findInitByCategoryIdPaged/{category_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Article> findInitByCategoryIdPaged(@PathVariable long category_id,@RequestParam(value = "date", required = true)String date, @RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "pubDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return articleService.findInitByCategoryIdPaged(category_id, inputDate, pageable);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "为文章点赞", response = Article.class)
    @RequestMapping(value = "/like/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    void like(@PathVariable long id) {
        articleService.like(id);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "取消为文章点赞", response = Article.class)
    @RequestMapping(value = "/like/{id}/cancel", method = RequestMethod.GET)
    public
    @ResponseBody
    void cancelLike(@PathVariable long id) {
        articleService.cancelLike(id);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "为文章拍砖", response = Article.class)
    @RequestMapping(value = "/dislike/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    void dislike(@PathVariable long id) {
        articleService.dislike(id);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "取消为文章拍砖", response = Article.class)
    @RequestMapping(value = "/dislike/{id}/cancle", method = RequestMethod.GET)
    public
    @ResponseBody
    void cancleDislike(@PathVariable long id) {
        articleService.cacleDislike(id);
    }

}
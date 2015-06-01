package whatever.controllers;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whatever.models.Comment;
import whatever.services.CommentService;

/**
 * Created by lijc on 15/4/25.
 */
@Api(basePath = "/comment", value = "comment", description = "评论", produces = "application/json",position = 10)
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Monitored
    @ApiOperation(httpMethod = "POST", value = "提交评论", response = Comment.class)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public
    @ResponseBody
    Comment create(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "根据文章id获取评论", response = Comment.class, responseContainer = "List")
    @RequestMapping(value = "/findById/{articleId}", method = RequestMethod.GET)
    public
    @ResponseBody
    Iterable<Comment> findById(@PathVariable long articleId) {
        return commentService.findCommentsOfArticle(articleId);
    }

}

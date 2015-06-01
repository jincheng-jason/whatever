package whatever.controllers;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import whatever.models.Category;
import whatever.services.CategoryService;

/**
 * Created by lijc on 15/4/10.
 */
@Api(basePath = "/category", value = "category", description = "公众号文章分类", produces = "application/json",position = 3)
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "根据id获取类别", response = Category.class)
    @RequestMapping("/findById/{id}")
    public
    @ResponseBody
    Category findById(@PathVariable long id) {
        return categoryService.findById(id);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "获取所有类别")
    @RequestMapping("/findAll")
    public
    @ResponseBody
    Iterable<Category> findAll() {
        return categoryService.findAll();
    }

}

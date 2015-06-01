package whatever.controllers;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whatever.models.UserBookAccount;
import whatever.services.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijc on 15/4/25.
 */
@Api(basePath = "/book", value = "book", description = "用户订阅", produces = "application/json",position = 5)
@RestController
@RequestMapping("/book")
public class BookController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookService bookService;

    @Monitored
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "用户订阅公众号", response = UserBookAccount.class, responseContainer = "List")
    public
    @ResponseBody
    List<UserBookAccount> book(@ApiParam("userBooks") @RequestBody List<UserBookAccount> userBooks) {
        List<UserBookAccount> books = new ArrayList<>();
        try {
            books = bookService.save(userBooks);
        } catch (Exception ex) {
            log.error(ex.toString());
        }
        return books;
    }

    @Monitored
    @RequestMapping(value = "/getByUser/{userId}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "获得用户订阅的公众号", response = UserBookAccount.class,responseContainer = "List")
    public
    @ResponseBody
    Iterable<UserBookAccount> getUserBook(@PathVariable long userId) {
            return bookService.getByUser(userId);
    }

}

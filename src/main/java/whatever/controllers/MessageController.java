package whatever.controllers;

import com.wordnik.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lijc on 15/4/25.
 */
@Api(basePath = "/message", value = "message", description = "消息", produces = "application/json",position = 7)
@RestController
@RequestMapping("/message")
public class MessageController {



}

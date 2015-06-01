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
import whatever.models.Event;
import whatever.services.EventService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lijc on 15/4/25.
 */
@Api(basePath = "/event", value = "event", description = "活动", produces = "application/json",position = 6)
@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "查找正在进行活动,包含输入时间")
    @RequestMapping(value = "/findInitStarted", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Event> findInitStarted(@RequestParam(value = "date", required = true)String date,@RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "beginAt");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return eventService.findStarted(inputDate,pageable);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "查找比输入时间更新的正在进行活动")
    @RequestMapping(value = "/findNewerStarted", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Event> findNewerStarted(@RequestParam(value = "date", required = true)String date,@RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "beginAt");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return eventService.findNewerStarted(inputDate,pageable);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "查找比输入时间更晚的正在进行活动")
    @RequestMapping(value = "/findOlderStarted", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Event> findOlderStarted(@RequestParam(value = "date", required = true)String date,@RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "beginAt");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return eventService.findOlderStarted(inputDate,pageable);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "查找未开始活动")
    @RequestMapping(value = "/findStarting", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Event> findStarting(@RequestParam(value = "date", required = true)String date,@RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "beginAt");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return eventService.findStarting(inputDate,pageable);
    }



    @Monitored
    @ApiOperation(httpMethod = "GET", value = "查找已结束活动")
    @RequestMapping(value = "/findInitEnded", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Event> findInitEnded(@RequestParam(value = "date", required = true)String date,@RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "endAt");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return eventService.findEnded(inputDate,pageable);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "查找比输入时间结束更晚的已结束活动")
    @RequestMapping(value = "/findNewerEnded", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Event> findNewerEnded(@RequestParam(value = "date", required = true)String date,@RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "endAt");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return eventService.findNewerEnded(inputDate,pageable);
    }

    @Monitored
    @ApiOperation(httpMethod = "GET", value = "查找比输入时间结束更早的已结束活动")
    @RequestMapping(value = "/findOlderEnded", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Event> findOlderEnded(@RequestParam(value = "date", required = true)String date,@RequestParam(value = "size", required = true) int page_size) {
        Pageable pageable = new PageRequest(0, page_size, Sort.Direction.DESC, "endAt");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date inputDate = null;
        try {
            inputDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return eventService.findOlderEnded(inputDate,pageable);
    }

}

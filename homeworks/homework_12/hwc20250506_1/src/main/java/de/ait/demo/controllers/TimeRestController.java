package de.ait.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TimeRestController {

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public Map<String, Object> getCurrentTime(){
        Map<String, Object> timeObjectMap = new HashMap<>();
        timeObjectMap.put("datetime", LocalDateTime.now().toString());
        return timeObjectMap;
    }
}

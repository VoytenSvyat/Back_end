package de.ait.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
public class TimeRestController {

    @RequestMapping(value = "/now", method = RequestMethod.GET)
    public Time getCurrentTime(){
        return new Time(LocalDateTime.now());
         /* return Datetime.builder()
                .day(now.getDayOfMonth())
                 .moth(now.getMoth().getValue())
                 .year(now.getYear())
                 .hour(now.getHour())
                 .minute(now.getMinute())
                 .build();
          */
    }
    @GetMapping("/now2")
    public String getTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
    }
}

/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-05-18 13:52
 * @Description:
 */
package com.cecil.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author LiMingChi 2016-05-18 13:52
 * @version V1.0
 */
@RestController
@RequestMapping("greeting")
@SpringBootApplication
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "{name}" , method = RequestMethod.GET)
    public Greeting greeting(@PathVariable String name)
    {
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}
package com.github.pcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ye Yan on 11/03/15.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public @ResponseBody String index() {
        return "hello world";
    }


    @RequestMapping("/hello/{name}")
    public @ResponseBody String hello(@PathVariable("name") String name) {
        return "hello " + name;
    }
}

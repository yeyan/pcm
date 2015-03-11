package com.github.pcm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ye Yan on 11/03/15.
 */
@Controller
public class IndexController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${root-directory}")
    void setRoot(String name) {
        logger.debug("root dir = {}", name);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello/{name}")
    public @ResponseBody String hello(@PathVariable("name") String name) {
        return "hello " + name;
    }
}

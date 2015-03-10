package com.github.pcm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Ye Yan on 11/03/15.
 */

@Configuration
@ComponentScan(basePackages = {"com.github.pcm"})
public class RootConfig {

    @Configuration
    @EnableWebMvc
    public static class WebConfig extends WebMvcConfigurerAdapter {
    }

}

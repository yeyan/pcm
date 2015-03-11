package com.github.pcm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * Created by Ye Yan on 11/03/15.
 */

@Configuration
@ComponentScan(basePackages = {"com.github.pcm"})
public class RootConfig {

    @Configuration
    @EnableWebMvc
    public static class WebConfig extends WebMvcConfigurerAdapter {

        @Bean
        public ViewResolver viewResolver(SpringTemplateEngine engine) {
            ThymeleafViewResolver resolver = new ThymeleafViewResolver();
            resolver.setTemplateEngine(engine);

            return resolver;
        }

        @Bean
        public SpringTemplateEngine templateEngine(TemplateResolver resolver) {
            SpringTemplateEngine engine = new SpringTemplateEngine();
            engine.setTemplateResolver(resolver);

            return engine;
        }

        @Bean
        public TemplateResolver tempateResolver() {
            TemplateResolver resolver = new ServletContextTemplateResolver();
            resolver.setPrefix("/WEB-INF/pages/");
            resolver.setSuffix(".html");

            return resolver;
        }
    }


}

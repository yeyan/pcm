package com.github.pcm.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
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

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer props = new PropertyPlaceholderConfigurer();
        props.setLocation(new ClassPathResource("app.properties"));

        return props;
    }

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

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/assets/**")
                    .addResourceLocations("classpath:/assets/");
        }
    }


}

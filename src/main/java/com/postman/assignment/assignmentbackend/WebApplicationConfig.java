package com.postman.assignment.assignmentbackend;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/dashboard").setViewName("forward:/");
        registry.addViewController("/assignment").setViewName("forward:/?angular_route=assignment");
        registry.addViewController("/login").setViewName("forward:/");
        registry.addViewController("/register").setViewName("forward:/");
        registry.addViewController("/404").setViewName("forward:/?angular_route=404");
        registry.addViewController("/notFound").setViewName("forward:/?angular_route=404");
    }


    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
        return container -> {
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
                    "/?angular_route=404"));
            container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN,
                    "/?angular_route=404"));
        };
    }

}
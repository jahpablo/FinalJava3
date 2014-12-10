package com.jahpablo.model.finaljava3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("com.jahpablo.controller.finaljava3")
public class WebApConfig extends WebMvcConfigurerAdapter{
    
}

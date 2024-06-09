package com.luv2code.springboot.demo.edi.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseballConfig {
    @Bean("123")
    public Coach baseballCoach()  {
        return new BaseballCoach();
    }
}

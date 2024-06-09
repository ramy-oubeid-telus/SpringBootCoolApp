package com.luv2code.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("CricketCoach constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {return "This is cricket workout voila";}
}

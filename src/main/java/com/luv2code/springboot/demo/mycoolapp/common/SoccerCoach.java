package com.luv2code.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

    public SoccerCoach() {
        System.out.println("SoccerCoach constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {return "Je suis un entraineur de Soccer!";}
}

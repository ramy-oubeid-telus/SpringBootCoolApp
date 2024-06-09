package com.luv2code.springboot.demo.mycoolapp.common;
import org.springframework.stereotype.Component;


public class BaseballCoach implements Coach{

    public BaseballCoach() {
        System.out.println("SwimCoach constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() { return " I'm a baseball coach!"; }

}

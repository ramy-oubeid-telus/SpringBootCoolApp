package com.healthai.springboot.demo.edi.common;


public class BaseballCoach implements Coach{

    public BaseballCoach() {
        System.out.println("SwimCoach constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() { return " I'm a baseball coach!"; }

}

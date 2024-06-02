package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {return "This is cricket workout";}
}

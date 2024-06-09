package com.luv2code.springboot.demo.mycoolapp.common;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("SwimCoach constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() { return " I am a swimming coach!"; }

}

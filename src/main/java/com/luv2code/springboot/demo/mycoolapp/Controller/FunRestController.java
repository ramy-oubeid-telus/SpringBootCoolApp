package com.luv2code.springboot.demo.mycoolapp.Controller;

import com.luv2code.springboot.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    Coach thecoach;

    @Autowired
    public FunRestController(@Qualifier("soccerCoach") Coach thecoach) {
        this.thecoach = thecoach;
    }

    // expose "/" that return "Hello World"

    @GetMapping("/")
    public String DisplayTheCouch() {
        return thecoach.getDailyWorkout();
    }
}

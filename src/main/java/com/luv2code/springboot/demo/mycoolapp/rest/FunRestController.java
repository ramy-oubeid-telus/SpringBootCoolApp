package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    Coach thecoach;
    public FunRestController(Coach thecoach) {
        this.thecoach = thecoach;
    }

    // expose "/" that return "Hello World"

    @GetMapping("/")
    public String DisplayTheCouch() {
        return thecoach.getDailyWorkout();
    }
}

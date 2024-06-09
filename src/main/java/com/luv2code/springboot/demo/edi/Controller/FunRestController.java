package com.luv2code.springboot.demo.edi.Controller;

import com.luv2code.springboot.demo.edi.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    Coach thecoach;
    Coach anotherCoach;

    @Autowired
    public FunRestController(
            @Qualifier("soccerCoach") Coach thecoach,
            @Qualifier("123") Coach anotherCoach ) {
        this.thecoach = thecoach;
        this.anotherCoach = anotherCoach;
    }

    // expose "/" that return "Hello World"

    @GetMapping("/getCoach")
    public String DisplayTheCouch() {
        return anotherCoach.getDailyWorkout();
    }

    @GetMapping("/getInformation")
    public String DisplayTheInformation() {

        String s = "Two soccerCoach are identical?" + (anotherCoach==thecoach);
        return s;
    }
}

package com.example.api.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {
    @RequestMapping(method = RequestMethod.GET)
    public String greeting() {
        return "{\"message\": \"Hello!\"}\n";
    }

}
package com.sap.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    Environment env;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}

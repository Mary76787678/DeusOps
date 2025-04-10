package ru.deusops.lab4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${greeting.name}")
    private String nameToGreet;

    @GetMapping
    public String greet() {
        return "Hello, " + nameToGreet + "!";
    }
}

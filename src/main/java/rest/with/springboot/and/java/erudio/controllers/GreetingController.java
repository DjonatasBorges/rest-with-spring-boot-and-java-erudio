package rest.with.springboot.and.java.erudio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.with.springboot.and.java.erudio.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(path = "/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World")
            String name ) {
        return new Greeting(String.format(template, name), counter.incrementAndGet());
    }
}

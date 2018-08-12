package net.sshplendid.examples.spring.net.sshplendid.examples.spring.greeting.controller;

import net.sshplendid.examples.spring.net.sshplendid.examples.spring.greeting.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private long sequence = 0;
    private static final String template = "Hello, %s!";

    private long next_sequence() {
        return ++sequence;
    }
    @GetMapping("/greeting")
    public Greeting greeting(String name) {
        return new Greeting(next_sequence(), name, String.format(template, name));
    }
    @GetMapping("/")
    public String home() {
        return "hello";
    }
}

package net.sshplendid.examples.spring.net.sshplendid.examples.spring.greeting;

import org.springframework.web.bind.annotation.RestController;

public class Greeting {
    private final long id;
    private final String name;
    private final String content;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Greeting(long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }
}

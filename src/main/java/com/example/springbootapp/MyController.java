package com.example.springbootapp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MyController {

    private final List<Message> messages = new ArrayList<>();

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/hello/?{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //!!!!!
    @PostMapping("/messages")
    public Message addMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }

    @GetMapping("/messages")
    public List<Message> listMessages() {
        return messages;
    }


    @DeleteMapping("/messages/{id}")
    public String delete(@PathVariable int id) {
        messages.remove(id);
        return "Message with ID  " + id + "removed.";

    }

}


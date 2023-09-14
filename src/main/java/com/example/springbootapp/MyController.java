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


    // http://localhost:8080/api/hello
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Marc!";
    }

    @GetMapping("/hello/?{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello, " + name + "!";

        // for this above use:
        // http://localhost:8080/api/hello/{boss
        // in Postman as Get request
    }

    //!!!!! THis is the good json Post & get tool:
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


    //http://localhost:8080/api/{{12345}}
    // oder http://localhost:8080/api/23424234
    @GetMapping("/{id}")
    public String getHelloPathVariable(@PathVariable String id) {
        System.out.println("PathVariable: " + id);
        return "Hello: " + id;

    }
}


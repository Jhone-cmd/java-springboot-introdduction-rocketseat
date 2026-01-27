package com.jhone_cmd.TodoList.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController()
@RequestMapping("/firstRoute")
public class FirstController {
    @GetMapping("/")
    public String getMethodName() {
        return "Hello from the first controller";
    }

}

package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
    @GetMapping("/student")
    public String indexStudent() {
        return "student";
    }

    @GetMapping("/class")
    public String indexClass() {
        return "class";
    }
}

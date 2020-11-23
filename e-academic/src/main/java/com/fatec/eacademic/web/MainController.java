package com.fatec.eacademic.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/teacher")
    public String teacherIndex() {
        return "teacher/index";
    }

    @GetMapping("/student")
    public String studentIndex() {
        return "student/index";
    }
}
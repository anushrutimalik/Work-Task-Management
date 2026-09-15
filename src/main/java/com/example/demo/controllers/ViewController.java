package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }
    @GetMapping("/user/dashboard")
    public String getDashboard() {
        return "user/dashboard";
    }

    @GetMapping("/employee-management")
    public String getEmployeeManagement() {
        return "employee-management";
    }

    @GetMapping("/work-management")
    public String getWorkManagement() {
        return "work-management";
    }
}
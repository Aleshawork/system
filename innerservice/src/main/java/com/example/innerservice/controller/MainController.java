package com.example.innerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/operate")
public class MainController {

    @GetMapping(value = "/")
    public String operate() {
        return "operate";
    }
}

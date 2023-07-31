package com.example.myservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/info")
public class InfoController {

    @Value("${service.node.name}")
    private String nodeName;

    @GetMapping(value ="/status")
    public HttpStatus getInfo() {
        System.out.println("Status Controller!");
        return HttpStatus.OK;
    }

    @GetMapping(value = "/name")
    public String getName() {
        System.out.println("Name Controller!");
        return String.format("Hello from %s", nodeName);
    }

}

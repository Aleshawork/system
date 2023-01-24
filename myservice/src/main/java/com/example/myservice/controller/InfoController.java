package com.example.myservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/info")
public class InfoController {

    @GetMapping(value ="/status")
    public HttpStatus getInfo() {
        return HttpStatus.OK;
    }

}

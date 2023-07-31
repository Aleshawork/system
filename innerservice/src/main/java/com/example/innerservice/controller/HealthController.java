package com.example.innerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/health")
public class HealthController {

    @RequestMapping(
            value = "/sayOk",
            method = {
                    RequestMethod.GET,
                    RequestMethod.POST,
                    RequestMethod.PUT,
                    RequestMethod.PATCH
            })
    public HttpStatus sayOk() {
        return HttpStatus.OK;
    }

}

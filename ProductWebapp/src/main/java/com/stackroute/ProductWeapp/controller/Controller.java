package com.stackroute.ProductWeapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product-webapp")
public class Controller {

    @GetMapping("/site")
    public String webapp() {
        return "index.html";
    }
}

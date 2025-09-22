package com.SagarDev.SpringWebApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String Home(){
        return "Hello World";
    }
    @RequestMapping("/about")
    public String About(){
        return "About Page";
    }
}

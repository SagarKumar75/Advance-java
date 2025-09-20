package com.SagarDev.my_app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dev {
    @RequestMapping("/")
    public String build(){
        return "Dev build";
    }
}

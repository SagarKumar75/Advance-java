package com.sagarDev.SpringSecurity.controller;

import com.sagarDev.SpringSecurity.model.Users;
import com.sagarDev.SpringSecurity.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService service;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public UserController(UserService service) {
        this.service = service;

    }


    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){

    return service.verify(user);
    }


}

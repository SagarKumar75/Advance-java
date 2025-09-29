package com.sagarDev.SpringSecurity.service;

import com.sagarDev.SpringSecurity.model.Users;
import com.sagarDev.SpringSecurity.repository.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo repo;
    AuthenticationManager authenticationManager;
    private JWTService jwtService;
    public UserService(UserRepo repo, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.repo = repo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }
    public Users register(Users user){
        return repo.save(user);

    }

    public String verify(Users user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) return jwtService.generateToken(user.getUsername());

        return "fail";
    }
}

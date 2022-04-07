package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {

        return userService.create(user);
    }

    @GetMapping("/users/current")
    public User getCurrentUser() {

        return userService.getCurrentUser();
    }

}

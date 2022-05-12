package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserPageController {
    private final UserService userService;
    @Autowired
    public UserPageController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public User getUser(@RequestHeader){

    }

}

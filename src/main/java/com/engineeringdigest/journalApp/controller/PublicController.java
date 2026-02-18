package com.engineeringdigest.journalApp.controller;

import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//this is file is use for testing and must to be made
@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService; //We formed instance

    @GetMapping("/health-check")
    public String healthCheck(){

        return "ok";
    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user){
        userService.saveNewEntry(user);
        //First save and then return user then they show hash password on postman
        return user;

    }

}

package com.engineeringdigest.journalApp.controller;


import com.engineeringdigest.journalApp.cache.AppCache;
import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppCache appCache;

    @GetMapping("/get-users")
    public ResponseEntity<?> getAllUser(){
        List<User> allUser = userService.getAll();
        if(allUser!=null && !allUser.isEmpty()){
            return new ResponseEntity<>(allUser , HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create-admin-user")
    public void createAdmin(@RequestBody User user){
        userService.saveAdmin(user);
    }

    @DeleteMapping("/delete-users")
    public void deleteAllUsers(){
        userService.deleteAll();
    }

    @GetMapping("/clear-app-cache")
    public void clearAppCache(){
        appCache.init();
    }

}





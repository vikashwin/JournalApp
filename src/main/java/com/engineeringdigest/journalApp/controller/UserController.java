package com.engineeringdigest.journalApp.controller;

import com.engineeringdigest.journalApp.api.response.WeatherResponse;
import com.engineeringdigest.journalApp.entity.JournalEntry;
import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.service.UserService;
import com.engineeringdigest.journalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;



    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //After hit the userName and password to the api end point it can encode the password and match  to the database
        // if it is exit then it can save in authentication by using SecurityContextHolder and password encoder
        //Matching password code is written in already spring And it can handle by spring security
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);

        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewEntry(userInDb);
        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);

    }
    @DeleteMapping
    public ResponseEntity<?> deleteByUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        userService.deleteByUserName(userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

    @GetMapping
    public ResponseEntity<?> greeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
        String greeting = "";
        if (weatherResponse != null) {
            greeting = ", Weather feels like " + weatherResponse.getCurrent().getTemperature() + " celsius:";
        }
        return new ResponseEntity<>("Hii  " + userName + greeting ,HttpStatus.OK);
    }





}

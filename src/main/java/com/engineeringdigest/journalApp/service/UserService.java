package com.engineeringdigest.journalApp.service;

import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j // After that use don't need to make instance of logger
public class UserService {


    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //This line is used for password encoder

    @Autowired
    private UserRepository userRepository;

//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean saveNewEntry(User user){

        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        }catch(Exception e){
            log.error("Error occurred for {}",user.getUserName());
            log.debug("Debug",e);
            log.info("Information");
            log.warn("warming");
            log.trace("Tracing");
            return false;
        }
    }

    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepository.save(user);
    }

    public void saveEntry(User user){
        userRepository.save(user);
    }


    public List<User> getAll(){

        return userRepository.findAll();
    }

    public Optional<User> findById(String id){
        return userRepository.findById(id);

    }

//  public void deleteById(String id){
//        userRepository.deleteById(id);
//    }

    public void deleteByUserName(String userName){
        userRepository.deleteByUserName(userName);
    }

    public void deleteAll(){
       userRepository.deleteAll();
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

}

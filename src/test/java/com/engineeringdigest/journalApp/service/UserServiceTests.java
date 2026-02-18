package com.engineeringdigest.journalApp.service;

import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
     private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Disabled
    @Test
    public void testAdd(){
        //assert means Dawa karna
        assertEquals(4,2+2);
        assertTrue(5>3);
    }

    @Disabled
    @Test
    public void testFindByUserName(){
        assertNotNull( userRepository.findByUserName("ram"),"User name not present:");
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,2,4",
            "2,4,6",
            "3,5,9"

    })

    public void test(int a , int b , int expected){

        assertEquals(expected , a+b);
    }

}

package com.engineeringdigest.journalApp.service;

import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;


//Use for mock testing without intracting with database for fast execution
@Disabled
public class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this); // updated method
    }


    @Disabled
    @Test
    public void loadUserByUserNameTest(){

        User mockUser = User.builder()
                .userName("ram")
                .password("jflkhsdf")
                .roles(new ArrayList<>())
                .build();

        when(userRepository.findByUserName(Mockito.anyString()))
                .thenReturn(mockUser);

        UserDetails user = userDetailsService.loadUserByUsername("ram");

        Assertions.assertNotNull(user);
        Assertions.assertEquals("ram", user.getUsername());
    }
}

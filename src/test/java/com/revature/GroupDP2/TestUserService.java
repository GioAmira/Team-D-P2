package com.revature.GroupDP2;

import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.UserRepository;
import com.revature.GroupDP2.services.UserService;
import com.revature.GroupDP2.util.StorageManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestUserService {
    private static UserRepository userRepository;
    private static UserService userService;
    private static User tu1;
    private static User tu2;

    @BeforeAll
    public static void beforeC(){
        userRepository=mock(UserRepository.class);
        userRepository=mock(UserRepository.class);
        userService = new UserService(userRepository);
    }
    @BeforeEach
    public void before(){
        tu1=new User("username","password",true,"John","Test",
                "EMAIL@EMAIL.COM","phone","street","city","state","zip");
        tu2=new User("wrong","wrong",true,"Mark","Test",
                "EMAIL@EMAIL.COM","phone","street","city","state","zip");
    }
    @AfterAll
    public static void afterC(){

    }
    @AfterEach
    public void after(){

    }

    @Test
    public void testUserRegisterSuccess() throws Exception {
        when(userRepository.getByUsername("username")).thenReturn(Optional.empty());
        userService.register(tu1);
    }
    @Test
    public void testUserRegisterFailAlreadyInsertedUser(){
        //I took this code from online =-)
        when(userRepository.getByUsername("username")).thenReturn(Optional.of(tu1));
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            userService.register(tu1);
        });
        Assertions.assertEquals("username already taken!", thrown.getMessage());
    }
    @Test
    public void testUserRegisterFailBadEmail(){
        tu1.setEmail("BADBADEMAIL.NONSENSE");
        when(userRepository.getByUsername("username")).thenReturn(Optional.empty());
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            userService.register(tu1);
        });
        Assertions.assertEquals("email invalid!", thrown.getMessage());
    }

}

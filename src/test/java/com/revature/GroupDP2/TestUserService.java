package com.revature.GroupDP2;

import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.UserRepository;
import com.revature.GroupDP2.services.UserService;
import com.revature.GroupDP2.util.StorageManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestUserService {
    private static UserRepository userRepository;
    private static UserService userService;
    private static User tu1;
    /*
    @BeforeClass
    public static void beforeC(){

    }
    @Before
    public void before(){

    }
    @AfterClass
    public static void afterC(){

    }
    @After
    public void after(){

    }
    */

    @Test
    public void testUserRegisterSuccess() throws Exception {
        userRepository=mock(UserRepository.class);
        when(userRepository.getByUsername("username")).thenReturn(Optional.empty());
        userService = new UserService(userRepository);
        tu1=new User("username","password",true,"John","Test",
                "email","phone","street","city","state","zip");
        System.out.println("befor e haas run");
        userService.register(tu1);
    }
}

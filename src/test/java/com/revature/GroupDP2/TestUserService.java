package com.revature.GroupDP2;

import com.revature.GroupDP2.repository.UserRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TestUserService {
    private static UserRepository userRepository;
    @BeforeClass
    public static void beforeC(){
    userRepository=mock(UserRepository.class);
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
    @Test
    public void testUserRegisterSuccess(){

    }
}

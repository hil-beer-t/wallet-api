package com.hilbert.wallet.repository;

import com.hilbert.wallet.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    private static final String EMAIL = "email@test.com";
    private static final String PASSWORD = "123";

    @Autowired
    UserRepository userRepository;

    @Before
    public void setup(){
        User setupUser = new User();
        setupUser.setName("setup user");
        setupUser.setPassword(PASSWORD);
        setupUser.setEmail(EMAIL);

        userRepository.save(setupUser);
    }

    @After
    public void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    public void testSaveUser(){
        User unsavedUser = new User();
        unsavedUser.setName("Test");
        unsavedUser.setPassword("125452");
        unsavedUser.setEmail("dwad@test.com");

        User savedUser = userRepository.save(unsavedUser);

        assertNotNull(savedUser);
    }

    @Test
    public void testFindByEmail(){
        Optional<User> userFound = userRepository.findByEmailEquals(EMAIL);

        assertTrue(userFound.isPresent());
        assertEquals(userFound.get().getEmail(), EMAIL);
    }
}

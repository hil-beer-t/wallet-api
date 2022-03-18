package com.hilbert.wallet.repository;

import com.hilbert.wallet.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testSaveUser(){
        User unsavedUser = new User();
        unsavedUser.setName("Test");
        unsavedUser.setPassword("125452");
        unsavedUser.setEmail("dwad@test.com");

        User savedUser = userRepository.save(unsavedUser);

        assertNotNull(savedUser);
    }
}

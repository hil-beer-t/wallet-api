package com.hilbert.wallet.service;

import com.hilbert.wallet.entity.User;
import com.hilbert.wallet.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Before
    public void setup(){
        BDDMockito.given(userRepository.findByEmailEquals(Mockito.anyString()))
                .willReturn(Optional.of(new User()));
    }

    @Test
    public void testFindByEmail() {
        Optional<User> user = userService.findByEmail("email@test.com");

        assertTrue(user.isPresent());
    }

}

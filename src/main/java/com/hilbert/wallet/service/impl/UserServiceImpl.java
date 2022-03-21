package com.hilbert.wallet.service.impl;

import com.hilbert.wallet.entity.User;
import com.hilbert.wallet.repository.UserRepository;
import com.hilbert.wallet.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmailEquals(email);
    }
}

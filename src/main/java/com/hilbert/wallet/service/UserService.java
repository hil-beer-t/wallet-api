package com.hilbert.wallet.service;

import com.hilbert.wallet.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findByEmail(String email);

}

package com.hilbert.wallet.repository;

import com.hilbert.wallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailEquals(String email);
}
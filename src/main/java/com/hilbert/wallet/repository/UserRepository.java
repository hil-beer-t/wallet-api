package com.hilbert.wallet.repository;

import com.hilbert.wallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
package com.hilbert.wallet.service.impl;

import com.hilbert.wallet.entity.UserWallet;
import com.hilbert.wallet.repository.UserWalletRepository;
import com.hilbert.wallet.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWalletServiceImpl implements UserWalletService {

    @Autowired
    UserWalletRepository userWalletRepository;

    @Override
    public UserWallet save(UserWallet userWallet) {
        return userWalletRepository.save(userWallet);
    }
}

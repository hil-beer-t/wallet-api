package com.hilbert.wallet.service.impl;

import com.hilbert.wallet.entity.Wallet;
import com.hilbert.wallet.repository.WalletRepository;
import com.hilbert.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;


    @Override
    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }
}

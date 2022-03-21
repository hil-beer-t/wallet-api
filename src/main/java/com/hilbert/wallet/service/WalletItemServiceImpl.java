package com.hilbert.wallet.service;

import com.hilbert.wallet.entity.WalletItem;
import com.hilbert.wallet.repository.WalletItemRepository;
import com.hilbert.wallet.util.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class WalletItemServiceImpl implements WalletItemService{

    @Autowired
    WalletItemRepository walletItemRepository;

    @Override
    public WalletItem save(WalletItem i) {
        return walletItemRepository.save(i);
    }

    @Override
    public Page<WalletItem> findBetweenDates(Long wallet, Date start, Date end, int page) {

        int itemPerPage = 10;
        PageRequest pg = PageRequest.of(page, itemPerPage);

        return walletItemRepository.findAllByWalletIdAndDateGreaterThanEqualAndDateLessThanEqual(
                wallet, start, end, pg
        );
    }

    @Override
    public List<WalletItem> findByWalletAndType(Long wallet, Type type) {
        return walletItemRepository.findByWalletIdAndType(wallet, type);
    }

    @Override
    public BigDecimal sumByWalletId(Long wallet) {
        return walletItemRepository.sumByWalletId(wallet);
    }
}

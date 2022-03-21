package com.hilbert.wallet.service.impl;

import com.hilbert.wallet.entity.WalletItem;
import com.hilbert.wallet.repository.WalletItemRepository;
import com.hilbert.wallet.service.WalletItemService;
import com.hilbert.wallet.util.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WalletItemServiceImpl implements WalletItemService {

    private final WalletItemRepository walletItemRepository;

    public WalletItemServiceImpl(WalletItemRepository walletItemRepository) {
        this.walletItemRepository = walletItemRepository;
    }

    @Override
    @CacheEvict(value = "findByWalletAndType", allEntries = true)
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
    @Cacheable(value = "findByWalletAndType")
    public List<WalletItem> findByWalletAndType(Long wallet, Type type) {
        return walletItemRepository.findByWalletIdAndType(wallet, type);
    }

    @Override
    public BigDecimal sumByWalletId(Long wallet) {
        return walletItemRepository.sumByWalletId(wallet);
    }

    @Override
    public Optional<WalletItem> findById(Long id) {
        return walletItemRepository.findById(id);
    }

    @Override
    @CacheEvict(value = "findByWalletAndType", allEntries = true)
    public void deleteById(Long id) {
        walletItemRepository.deleteById(id);
    }
}

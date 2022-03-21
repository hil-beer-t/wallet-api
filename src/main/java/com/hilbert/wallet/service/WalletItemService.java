package com.hilbert.wallet.service;

import com.hilbert.wallet.entity.WalletItem;
import com.hilbert.wallet.util.Type;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface WalletItemService {
    WalletItem save(WalletItem i);

    Page<WalletItem> findBetweenDates(Long wallet, Date start, Date end, int page);

    List<WalletItem> findByWalletAndType(Long wallet, Type type);

    BigDecimal sumByWalletId(Long id);

    Optional<WalletItem> findById(Long id);

    void deleteById(Long id);
}

package com.hilbert.wallet.repository;

import com.hilbert.wallet.entity.WalletItem;
import com.hilbert.wallet.util.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface WalletItemRepository extends JpaRepository<WalletItem, Long> {
    

    List<WalletItem> findByWalletIdAndType(Long wallet, Type type);

    Page<WalletItem> findAllByWalletIdAndDateGreaterThanEqualAndDateLessThanEqual(Long wallet, Date init, Date end, Pageable pg);
}
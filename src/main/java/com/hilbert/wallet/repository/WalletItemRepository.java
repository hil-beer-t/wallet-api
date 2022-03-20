package com.hilbert.wallet.repository;

import com.hilbert.wallet.entity.WalletItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletItemRepository extends JpaRepository<WalletItem, Long> {
}
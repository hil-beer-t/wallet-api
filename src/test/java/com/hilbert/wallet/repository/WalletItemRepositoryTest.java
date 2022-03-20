package com.hilbert.wallet.repository;

import com.hilbert.wallet.entity.Wallet;
import com.hilbert.wallet.entity.WalletItem;
import com.hilbert.wallet.util.Type;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletItemRepositoryTest {
    private static final Date DATE = new Date();
    private static final Type TYPE = Type.EN;
    private static final String DESCRIPTION = "Conta de luz";
    private static final BigDecimal VALUE= BigDecimal.valueOf(50);
    private Long savedWalletItemId = null;
    private Long savedWalletId = null;

    @Autowired
    WalletItemRepository repository;

    @Autowired
    WalletRepository walletRepository;

    @Before
    public void setup(){
        Wallet w = new Wallet();
        w.setName("Carteira Test");
        w.setValue(BigDecimal.valueOf(250));
        walletRepository.save(w);

        WalletItem wi = new WalletItem(null, w, DATE, TYPE, DESCRIPTION, VALUE);
        repository.save(wi);

        savedWalletItemId = wi.getId();
        savedWalletId = w.getId();
    }

    @After
    public void tearDown() {
        repository.deleteAll();
        walletRepository.deleteAll();
    }

    @Test
    public void testSave(){
        Wallet w = new Wallet();
        w.setName("Carteira 1");
        w.setValue(BigDecimal.valueOf(500));

        walletRepository.save(w);

        WalletItem wi = new WalletItem(1L, w, DATE, TYPE, DESCRIPTION, VALUE);
        WalletItem response = repository.save(wi);

        assertNotNull(response);
        assertEquals(response.getDescription(), DESCRIPTION);
        assertEquals(response.getType(), TYPE);
        assertEquals(response.getValue(), VALUE);
        assertEquals(response.getType(), TYPE);
        assertEquals(response.getWallet().getId(), w.getId());
    }
}
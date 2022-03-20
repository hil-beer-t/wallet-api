package com.hilbert.wallet.entity;

import com.hilbert.wallet.util.Type;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "wallet_items")
public class WalletItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet", referencedColumnName = "id")
    private Wallet wallet;
    @NotNull
    private Date date;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;
    @NotNull
    private String description;
    @NotNull
    private BigDecimal value;

    public WalletItem() {
    }

    public WalletItem(Long id, Wallet wallet, Date date, Type type, String description, BigDecimal value){
        this.id = id;
        this.wallet = wallet;
        this.date = date;
        this.type = type;
        this.description = description;
        this.value = value;
    }
}
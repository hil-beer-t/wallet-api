package com.hilbert.wallet.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserWalletDTO {
    private Long id;
    @NotNull(message = "Informe o id do usuário")
    private Long usersId;
    @NotNull(message = "Informe o id da carteira")
    private Long walletId;
}

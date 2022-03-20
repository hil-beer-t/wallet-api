package com.hilbert.wallet.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletDTO {
    private Long id;
    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 3, message = "O nome deve conter no mínimo 3 caracteres")
    private String name;
    @NotNull(message = "Insira um valor para a carteira")
    private BigDecimal value;
}

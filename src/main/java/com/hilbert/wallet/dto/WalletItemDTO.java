package com.hilbert.wallet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class WalletItemDTO {

    private Long id;
    @NotNull(message = "Insira o id da carteira")
    private Long wallet;
    @NotNull(message = "Informe uma data")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private Date date;
    @NotNull(message = "Informe um tipo")
    @Pattern(regexp = "^(ENTRADA|SAÍDA)$", message = "Tipos aceitos: ENTRADA | SAÍDA")
    private String type;
    @NotNull(message = "Informe uma descrição")
    @Size(min = 5, message = "A descrição deve conter no mínimo 5 caracteres")
    private String description;
    @NotNull(message = "Informe um valor")
    private BigDecimal value;

}

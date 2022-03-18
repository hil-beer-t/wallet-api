package com.hilbert.wallet.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class UserDTO {

    private Long id;

    @Min(value = 3, message = "O número de caracteres mínimo no NOME é 3")
    @Max(value = 50, message = "O número de caracteres máximo no NOME é 50")
    private String name;

    @Min(value = 6, message = "O número de caracteres mínimo na SENHA é 6")
    @Max(value = 50, message = "O número de caracteres máximo NA SENHA 30")
    private String password;

    @Email(message = "Email inválido")
    private String email;

}

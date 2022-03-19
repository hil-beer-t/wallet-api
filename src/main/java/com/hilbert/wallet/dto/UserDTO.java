package com.hilbert.wallet.dto;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    @Size(min = 3, max = 50, message = "O nome deve conter entre 3 e 50 caracteres")
    private String name;

    @NotNull
    @Min(value = 6, message = "O número de caracteres mínimo na SENHA é 6")
    @Max(value = 50, message = "O número de caracteres máximo NA SENHA 30")
    private String password;

    @Email(message = "Email inválido")
    private String email;

}

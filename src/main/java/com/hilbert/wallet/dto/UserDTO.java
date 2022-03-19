package com.hilbert.wallet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;

    @Size(min = 3, max = 50, message = "O nome deve conter entre 3 e 50 caracteres")
    private String name;

    @NotNull
    @Size(min = 6, max = 30, message = "O senha deve conter entre 6 e 30 caracteres")
    private String password;

    @Email(message = "Email inválido")
    private String email;

}

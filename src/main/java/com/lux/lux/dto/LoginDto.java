package com.lux.lux.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginDto {
       @NotEmpty(message = "Questo campo non puo essere vuoto")
    private String email;
    @NotEmpty(message = "Questo campo non puo essere vuoto")
    private String password;
}

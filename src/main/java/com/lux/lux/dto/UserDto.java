package com.lux.lux.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDto {
     @NotEmpty(message = "Questo campo no puo essere vuoto")
    private String email;
    @NotEmpty(message = "Questo campo no puo essere vuoto")
    private String password;
}

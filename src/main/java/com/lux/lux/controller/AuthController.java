package com.lux.lux.controller;

import com.lux.lux.dto.LoginDto;
import com.lux.lux.dto.UserDto;
import com.lux.lux.exception.NonTrovatoException;
import com.lux.lux.exception.ValidationException;
import com.lux.lux.model.User;
import com.lux.lux.service.AuthService;
import com.lux.lux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

 @PostMapping("/auth/register")
    public User register(@RequestBody @Validated UserDto userDto, BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("",(s,e)->s+e));

        }

      return   userService.saveUser(userDto);


    }

    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated LoginDto loginDto, BindingResult bindingResult) throws ValidationException, NonTrovatoException {
        if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("",(s,e)->s+e));

        }


        return authService.login(loginDto);

    }


}

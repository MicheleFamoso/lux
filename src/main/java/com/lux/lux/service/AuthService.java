package com.lux.lux.service;


import com.lux.lux.dto.LoginDto;
import com.lux.lux.exception.NonTrovatoException;
import com.lux.lux.model.User;
import com.lux.lux.repository.UserRepository;
import com.lux.lux.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTool jwtTool;

    public String login(LoginDto loginDto) throws NonTrovatoException {
        User user = userRepository.findByEmail(loginDto.getEmail()).
                orElseThrow(() -> new NonTrovatoException("Utente con username/password non trovato"));
        if (loginDto.getPassword().equals(user.getPassword())) {

            return jwtTool.createToken(user);


        } else {
            throw new NonTrovatoException("Utente con username/password non trovato");
        }
    }
}

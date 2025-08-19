package com.lux.lux.service;

import com.lux.lux.dto.UserDto;
import com.lux.lux.exception.NonTrovatoException;
import com.lux.lux.model.User;
import com.lux.lux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User saveUser(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    public User getUser(int id) throws NonTrovatoException {
        return   userRepository.findById(id).orElseThrow(()-> new NonTrovatoException("Utente non trovato"));
    }

    public User updatePassword(int id, UserDto userDto) throws NonTrovatoException {
        User user= getUser(id);
        user.setEmail(user.getEmail());
        user.setPassword(userDto.getPassword());
        return userRepository.save(user);
    }


}

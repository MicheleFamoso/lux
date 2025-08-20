package com.lux.lux.controller;


import com.lux.lux.dto.BioDto;
import com.lux.lux.exception.NonTrovatoException;
import com.lux.lux.exception.ValidationException;
import com.lux.lux.model.Bio;
import com.lux.lux.service.BioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BioController {

    @Autowired
    private BioService bioService;


    @PostMapping("/bio")
    @ResponseStatus(HttpStatus.CREATED)
    public Bio saveBio(@RequestBody @Validated BioDto bioDto, BindingResult bindingResult) throws ValidationException {
         if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("",(e, c)->e+c));
        }
         return bioService.saveBio(bioDto);
    }

    @GetMapping("/bio")
    public List<Bio> getBios(){
        return bioService.getAllBio();
    }

    @GetMapping("/bio/{id}")
    public Bio getBio (@PathVariable int id) throws NonTrovatoException {
        return bioService.getBio(id);
    }

    @PutMapping("bio/{id}")
    public Bio updateBio(@PathVariable int id,
                         @RequestBody @Validated BioDto bioDto,
                         BindingResult bindingResult) throws ValidationException, NonTrovatoException {
         if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("",(e, c)->e+c));
        }
         return bioService.updateBio(id,bioDto);
    }



}

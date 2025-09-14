package com.lux.lux.controller;

import com.lux.lux.dto.MostreDto;
import com.lux.lux.exception.NonTrovatoException;
import com.lux.lux.exception.ValidationException;
import com.lux.lux.model.Mostre;
import com.lux.lux.repository.MostreRepository;
import com.lux.lux.service.MostreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MostreController {
        @Autowired
    private MostreService mostreService;

    @PostMapping("/mostre")
    @ResponseStatus(HttpStatus.CREATED)
    public Mostre saveMostra(@RequestBody @Validated MostreDto mostreDto, BindingResult bindingResult) throws ValidationException {
         if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("",(e, c)->e+c));
        }
         return mostreService.saveMostra(mostreDto);

    }

    @GetMapping("/mostre")
    public List<Mostre> getMostre(){return mostreService.getMostre();}


    @GetMapping("/mostre/{id}")
    public Mostre getMostra(@PathVariable int id) throws NonTrovatoException {
        return mostreService.getMostra(id);
    }

    @PutMapping
    public Mostre updateMostre(@PathVariable int id,
                              @RequestBody @Validated MostreDto mostreDto,
                               BindingResult bindingResult) throws ValidationException, NonTrovatoException {
                  if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("",(e, c)->e+c));
        }
                  return mostreService.updateMostre(id, mostreDto);

    }
    @DeleteMapping("/mostre/{id}")
    public void deleteMostra(@PathVariable int id) throws NonTrovatoException {
        mostreService.deleteMostra(id);
    }

}

package com.lux.lux.service;

import com.lux.lux.dto.BioDto;
import com.lux.lux.exception.NonTrovatoException;
import com.lux.lux.model.Bio;
import com.lux.lux.repository.BioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BioService {
    @Autowired
    private BioRepository bioRepository;

    public Bio saveBio(BioDto bioDto){
        Bio bio = new Bio();
        bio.setBio(bioDto.getBio());
        bio.setNome(bioDto.getNome());
        bio.setEmail(bioDto.getEmail());
        return bioRepository.save(bio);
    }

    public List<Bio> getAllBio(){
        return bioRepository.findAll();
    }


    public Bio getBio(int id) throws NonTrovatoException {
        return bioRepository.findById(id).
                orElseThrow(()->new NonTrovatoException("Bio non trovata"));
    }

    public Bio updateBio(int id, BioDto bioDto) throws NonTrovatoException {
        Bio bio= getBio(id);
        bio.setEmail(bioDto.getEmail());
        bio.setBio(bioDto.getBio());
        bio.setNome(bioDto.getNome());
        return bioRepository.save(bio);
    }
}

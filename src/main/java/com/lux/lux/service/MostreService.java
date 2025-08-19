package com.lux.lux.service;

import com.lux.lux.dto.MostreDto;
import com.lux.lux.exception.NonTrovatoException;
import com.lux.lux.model.Mostre;
import com.lux.lux.repository.MostreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostreService {
    @Autowired
    private MostreRepository mostreRepository;

    public Mostre saveMostra(MostreDto mostreDto){
        Mostre mostre = new Mostre();
        mostre.setData(mostreDto.getData());
        mostre.setTitolo(mostreDto.getTitolo());
        mostre.setLuogo(mostreDto.getLuogo());
        mostre.setDescrizione(mostreDto.getDescrizione());
        return  mostreRepository.save(mostre);
    }
    public List<Mostre> getMostre(){return mostreRepository.findAll();}

    public Mostre getMostra(int id) throws NonTrovatoException {
        return mostreRepository.findById(id).
                orElseThrow(()->new NonTrovatoException("Mostra non trovata"));
    }

    public Mostre updateMostre(int id, MostreDto mostreDto) throws NonTrovatoException {
        Mostre mostre = getMostra(id);
         mostre.setData(mostreDto.getData());
        mostre.setTitolo(mostreDto.getTitolo());
        mostre.setLuogo(mostreDto.getLuogo());
        mostre.setDescrizione(mostreDto.getDescrizione());
        return  mostreRepository.save(mostre);
    }

    public void deleteMostra(int id) throws NonTrovatoException {
        Mostre mostraDaEliminare = getMostra(id);
        mostreRepository.delete(mostraDaEliminare);
    }
}

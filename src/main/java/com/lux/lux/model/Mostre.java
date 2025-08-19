package com.lux.lux.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Locked;

import java.time.LocalDate;

@Data
@Entity
public class Mostre {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate data;
    private String luogo;
    private String titolo;
    private String descrizione;

}

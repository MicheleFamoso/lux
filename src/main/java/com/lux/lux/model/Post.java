package com.lux.lux.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate data;
    private String primaImmagine;
    private String secondaImmagine;
    private String terzaImmagine;
    private String titolo;
    private String dimensione;
    private String descrizione;
}

package com.lux.lux.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostDto {
      private LocalDate data;
    private String primaImmagine;
    private String secondaImmagine;
    private String terzaImmagine;
    private String titolo;
    private String dimensione;
    private String descrizione;
}

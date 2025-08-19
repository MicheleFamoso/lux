package com.lux.lux.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
public class Bio {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String email;
    private String bio;
}

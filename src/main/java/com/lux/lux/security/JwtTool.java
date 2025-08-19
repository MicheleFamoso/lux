package com.lux.lux.security;


import com.lux.lux.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

//classe gestita da Spring e  Gestirà i token
@Component
public class JwtTool {

    @Value("${jwt.duration}")
    private long durata;
    @Value("${jwt.secret}")
    private String chiaveSegreta;


    //Per Generare il token abbiamo bisogno
    // 1)Data
    // 2)Durata
    // 3)Id utente
    //4) chiave segreta per crittografare il token
    public String createToken(User user){
        return    Jwts.builder().issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+ durata)).//Data + durata
                subject(user.getId()+""). //Id concatenato con stringa vuota cosi l'id viene convertito in stringa
                signWith(Keys.hmacShaKeyFor(chiaveSegreta.getBytes())).compact() ;//Chiave
    }


    //Metodo verifica validita token

    public void validateToken(String token){
        Jwts.parser().verifyWith(Keys.hmacShaKeyFor(chiaveSegreta.getBytes())).
                build().parse(token);
    }



}

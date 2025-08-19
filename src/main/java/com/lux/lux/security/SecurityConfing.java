package com.lux.lux.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //Abilita classe a essere responsabile della sicurezza dei servizi
public class SecurityConfing {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       //serve per creare pagina login ma disabilitato perche ora non ci serve un form
        httpSecurity.formLogin(http->http.disable());
        //Serve per evitare la possibiltya di sessioni aperte, ma i rest non usano sessioni
        httpSecurity.csrf(http->http.disable());
        //Idem non abbiamo sessioni
        httpSecurity.sessionManagement(http->http.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        //Protezione da parte dei server, quando la richesta non parte dallo stesso dominio del server
        httpSecurity.cors(Customizer.withDefaults());

        //Permette l'autorizzazione ad eventuali path
        httpSecurity.authorizeHttpRequests(http->http.requestMatchers("/auth/**").permitAll());

//        httpSecurity.authorizeHttpRequests(http->http.requestMatchers(HttpMethod.GET,"/studenti/**").permitAll());
            //Gesto invece permette i metodi
        httpSecurity.authorizeHttpRequests(http->http.requestMatchers(HttpMethod.GET).permitAll());
        httpSecurity.authorizeHttpRequests(http->http.requestMatchers(HttpMethod.POST).permitAll());

        //Nega qualsiasi altro permesso che non abbiamo specificato prima
        httpSecurity.authorizeHttpRequests(http->http.anyRequest().denyAll());

        return httpSecurity.build();
    }

}

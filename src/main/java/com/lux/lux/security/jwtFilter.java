package com.lux.lux.security;




import com.lux.lux.exception.NonTrovatoException;
import com.lux.lux.exception.UnAutorizedEx;
import com.lux.lux.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class jwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTool jwtTool;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


         String authorization = request.getHeader("Authorization");

 if(authorization==null || !authorization.startsWith("Bearer ")){
        throw new UnAutorizedEx("Token non presente, non sei autorizzato ad usare il servizio richiesto");
      }
      else{
        String token = authorization.substring(7);
        jwtTool.validateToken(token);
        try {
          User user = jwtTool.getUserFromToken(token);
          Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
          SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (ChangeSetPersister.NotFoundException | NonTrovatoException e){
          throw new UnAutorizedEx("Utente collegato al token non trovato");
        }
        filterChain.doFilter(request, response);
      }

    }





    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getServletPath();
        String method = request.getMethod();


        return path.startsWith("/auth/") ||
                (HttpMethod.GET.matches(method) &&
                        (path.startsWith("/bio") || path.startsWith("/mostre") || path.startsWith("/post")));
    }

}

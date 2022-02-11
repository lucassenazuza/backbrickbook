package com.site.backbrickbook.service.auth;


import com.site.backbrickbook.exception.ExistingEmailException;
import com.site.backbrickbook.exception.ExpiredTokenException;
import com.site.backbrickbook.exception.InvalidLoginException;
import com.site.backbrickbook.exception.InvalidTokenException;
import com.site.backbrickbook.model.User;
import com.site.backbrickbook.model.dto.auth.DadosLogin;
import com.site.backbrickbook.repository.UserRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserAuthenticationService {

    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Autowired
    public UserAuthenticationService(UserRepository userRepository, TokenService tokenService){
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User authenticate(DadosLogin dados){
        User user = userRepository.findByEmail(dados.getEmail()).orElseThrow(ExistingEmailException::new);
        if(dados.getPassword().equals(user.getPassword())) {
            return user;
        }
        else {
            throw new InvalidLoginException();
        }
    }

//    public User authenticate(DadosLogin dados, String token){
//        User user = userRepository.findByEmail(dados.getEmail()).orElseThrow(ExistingEmailException::new);
//        if(dados.getpassword().equals(user.getpassword()) && !token.isEmpty() && validate(token)) {
//            return user;
//        }
//        else {
//            throw new InvalidLoginException();
//        }
//    }

    private boolean validate(String token) {
        try {
            String tokenTratado = token.replace("Bearer ", "");
            Claims claims = tokenService.decodeToken(tokenTratado);

            System.out.println(claims.getIssuer());
            System.out.println(claims.getIssuedAt());
            //Verifica se o token está expirado
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
            System.out.println(claims.getExpiration());
            return true;
        } catch (ExpiredTokenException et){
            et.printStackTrace();
            throw et;
        } catch (Exception e) {
            e.printStackTrace();
            throw new InvalidTokenException();
        }

    }


}

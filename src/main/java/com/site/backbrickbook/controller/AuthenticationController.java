package com.site.backbrickbook.controller;


import com.site.backbrickbook.model.User;
import com.site.backbrickbook.model.dto.DadosLogin;
import com.site.backbrickbook.model.dto.UserAutheticatedDTO;
import com.site.backbrickbook.service.UserAuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AuthenticationController {

    private UserAuthenticationService userAuthenticationService;

    @Autowired
    public AuthenticationController(UserAuthenticationService userAuthenticationService){
        this.userAuthenticationService = userAuthenticationService;
    }

    public AuthenticationController(){

    }


    @PostMapping("/signin")
    public ResponseEntity<UserAutheticatedDTO> autenticar(@RequestBody DadosLogin dadosLogin){
        User user = userAuthenticationService.authenticate(dadosLogin);
        return new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    }
//    @PostMapping("/login")
//    public ResponseEntity<UserAutheticatedDTO> autenticar(@RequestBody DadosLogin dadosLogin, @RequestHeader String Authorization){
//        User user = userAuthenticationService.authenticate(dadosLogin, Authorization);
//        return new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
//    }
}

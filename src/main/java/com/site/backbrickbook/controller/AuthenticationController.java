package com.site.backbrickbook.controller;


import com.site.backbrickbook.model.UserSystem;
import com.site.backbrickbook.model.dto.DadosLogin;
import com.site.backbrickbook.model.dto.UserAutheticatedDTO;
import com.site.backbrickbook.service.auth.UserAuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@CrossOrigin
@RestController
public class AuthenticationController {
    private static final Logger LOGGER = Logger.getLogger( AuthenticationController.class.getName() );
    private UserAuthenticationService userAuthenticationService;

    @Autowired
    public AuthenticationController(UserAuthenticationService userAuthenticationService){
        this.userAuthenticationService = userAuthenticationService;
    }

    public AuthenticationController(){

    }


    @PostMapping("/signin")
    public ResponseEntity<UserAutheticatedDTO> autenticar(@RequestBody DadosLogin dadosLogin){
        LOGGER.info("Logando usuario");
        UserSystem userSystem = userAuthenticationService.authenticate(dadosLogin);
        return new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(userSystem, "Bearer "), HttpStatus.ACCEPTED);
    }
//    @PostMapping("/login")
//    public ResponseEntity<UserAutheticatedDTO> autenticar(@RequestBody DadosLogin dadosLogin, @RequestHeader String Authorization){
//        User user = userAuthenticationService.authenticate(dadosLogin, Authorization);
//        return new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
//    }
}

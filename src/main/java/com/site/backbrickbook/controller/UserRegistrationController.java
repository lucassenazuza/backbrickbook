package com.site.backbrickbook.controller;


import com.site.backbrickbook.model.UserSystem;
import com.site.backbrickbook.model.dto.UserAutheticatedDTO;
import com.site.backbrickbook.model.dto.UserRegistrationDTO;
import com.site.backbrickbook.service.auth.UserRegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/register")
@RestController
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService){
        this.userRegistrationService = userRegistrationService;
    }
    @PostMapping
    public ResponseEntity<UserAutheticatedDTO> registrate(@RequestBody UserRegistrationDTO userRegistrationDTO){
        UserSystem userSystem = userRegistrationService.registrate(userRegistrationDTO.converter());
        return  new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(userSystem, "Bearer "), HttpStatus.CREATED);
    }

}

package com.site.backbrickbook.controller;


import com.site.backbrickbook.model.User;
import com.site.backbrickbook.model.dto.UserAutheticatedDTO;
import com.site.backbrickbook.model.dto.UserRegistrationDTO;
import com.site.backbrickbook.service.UserRegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService){
        this.userRegistrationService = userRegistrationService;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserAutheticatedDTO> registrate(@RequestBody UserRegistrationDTO userRegistrationDTO){
        User user = userRegistrationService.registrate(userRegistrationDTO.toUser());
        return  new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.CREATED);
    }

}

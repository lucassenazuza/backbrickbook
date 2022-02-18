package com.site.backbrickbook.service.auth;



import com.site.backbrickbook.model.UserSystem;
import com.site.backbrickbook.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    public UserRegistrationService(UserRepository userRepository, TokenService tokenService){
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public UserSystem registrate(UserSystem userSystem){
        userSystem.setToken(tokenService.generateToken(userSystem));
        return userRepository.save(userSystem);
    }

}

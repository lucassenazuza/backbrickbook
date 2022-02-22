package com.site.backbrickbook.controller;



import com.site.backbrickbook.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/email")
@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public void sendEmail(){
            emailService.sendMail("lucassenazuza@gmail.com",
        "asfasdf",
        "asdfasdf");
    }
}

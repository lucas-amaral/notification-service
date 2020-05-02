package com.proposta.aceita.notificationservice.controllers;

import com.proposta.aceita.notificationservice.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PutMapping("/match/{negotiationId}")
    public ResponseEntity<?> approvedByBuyer(@PathVariable String negotiationId) {
//        emailService.sendMatchEmailForBuyer(id);
        return ResponseEntity.ok().build();
    }
}

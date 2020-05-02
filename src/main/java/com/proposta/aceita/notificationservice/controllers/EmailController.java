package com.proposta.aceita.notificationservice.controllers;

import com.proposta.aceita.notificationservice.entities.Negotiation;
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

    @PutMapping("/match-to-seller")
    public ResponseEntity<?> matchToSeller(@RequestBody Negotiation negotiation) {
        emailService.sendMatchEmailForSeller(negotiation);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/match-to-buyer")
    public ResponseEntity<?> matchToBuyer(@RequestBody Negotiation negotiation) {
        emailService.sendMatchEmailForBuyer(negotiation);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/deal")
    public ResponseEntity<?> deal(@RequestBody Negotiation negotiation) {
        emailService.sendDealEmail(negotiation);
        return ResponseEntity.ok().build();
    }
}

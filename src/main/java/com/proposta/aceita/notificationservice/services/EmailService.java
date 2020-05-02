package com.proposta.aceita.notificationservice.services;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailService {

    private final SendGridEmailService sendGridEmailService;
    private final TemplateService templateService;

    public EmailService(SendGridEmailService sendGridEmailService, TemplateService templateService) {
        this.sendGridEmailService = sendGridEmailService;
        this.templateService = templateService;
    }

    public void sendMatchEmailForSeller(String email, String name) {

        var variables = Map.of(
            "name", name
        );

        var message = templateService.process("matchEmail", variables);

        var subject = "Você possui uma nova proposta para avaliar";

        sendGridEmailService.sendText("propostaceita+contato@gmail.com", email, subject, message);

    }

    public void sendMatchEmailForBuyer(String email, String name) {

        var variables = Map.of(
                "name", name
        );

        var message = templateService.process("propertyEmail", variables);

        var subject = "Você possui uma novo imóvel para avaliar";

        sendGridEmailService.sendText("propostaceita+contato@gmail.com", email, subject, message);

    }

    public void sendDealEmail(String negotiationId) {

        var variables = Map.of(
                "negotiationId", negotiationId
        );

        var message = templateService.process("dealEmail", variables);

        var subject = "Finalização de compra";

        sendGridEmailService.sendText("propostaceita+contato@gmail.com", "propostaceita@gmail.com", subject, message);

    }

}

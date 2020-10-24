package com.proposta.aceita.notificationservice.services;

import com.proposta.aceita.notificationservice.entities.Negotiation;
import com.proposta.aceita.notificationservice.services.integrations.CrmService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailService {

    private final SendGridEmailService sendGridEmailService;
    private final TemplateService templateService;
    private final CrmService crmService;

    public EmailService(SendGridEmailService sendGridEmailService, TemplateService templateService, CrmService crmService) {
        this.sendGridEmailService = sendGridEmailService;
        this.templateService = templateService;
        this.crmService = crmService;
    }

    public void sendMatchEmailForSeller(Negotiation negotiation) {

        crmService.getUserByProperty(negotiation.getSale().getPropertyId()).ifPresentOrElse(user -> {

            Map<String, Object> variables = Map.of("username", user.getName());

            var message = templateService.process("matchEmail", variables);

            var subject = "Você possui uma nova proposta";

            sendGridEmailService.sendHTML("propostaceita+contato@gmail.com", user.getEmail(), subject, message);

        }, () -> { throw new  RuntimeException("No user found"); });

    }

    public void sendMatchEmailForBuyer(Negotiation negotiation) {

        crmService.getUserByInterest(negotiation.getInterest().getId()).ifPresentOrElse(user -> {

            Map<String, Object> variables = Map.of("username", user.getName());

            var message = templateService.process("propertyEmail", variables);

            var subject = "Você possui uma novo imóvel para avaliar";

            sendGridEmailService.sendHTML("propostaceita+contato@gmail.com", user.getEmail(), subject, message);

        }, () -> { throw new  RuntimeException("No user found"); });

    }

    public void sendDealEmail(Negotiation negotiation) {

        Map<String, Object> variables = Map.of("negotiationId", negotiation.getId());

        var message = templateService.process("dealEmail", variables);

        var subject = "Finalização de compra";

        sendGridEmailService.sendHTML("propostaceita+contato@gmail.com", "propostaceita@gmail.com", subject, message);

    }

}

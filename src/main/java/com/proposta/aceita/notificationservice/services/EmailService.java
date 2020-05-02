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

        crmService.getBuyerEmail(negotiation.getSale().getPropertyId()).ifPresentOrElse(user -> {

            var variables = Map.of("name", user.getName());

            var message = templateService.process("matchEmail", variables);

            var subject = "Você possui uma nova proposta para avaliar";

            sendGridEmailService.sendText("propostaceita+contato@gmail.com", user.getEmail(), subject, message);

        }, () -> { throw new  RuntimeException("No user found"); });

    }

    public void sendMatchEmailForBuyer(Negotiation negotiation) {

        var variables = Map.of("name", negotiation.getInterest().getUser().getName());

        var message = templateService.process("propertyEmail", variables);

        var subject = "Você possui uma novo imóvel para avaliar";

        sendGridEmailService.sendText("propostaceita+contato@gmail.com", negotiation.getInterest().getUser().getEmail(), subject, message);

    }

    public void sendDealEmail(Negotiation negotiation) {

        var variables = Map.of(
                "negotiationId", negotiation.getId()
        );

        var message = templateService.process("dealEmail", variables);

        var subject = "Finalização de compra";

        sendGridEmailService.sendText("propostaceita+contato@gmail.com", "propostaceita@gmail.com", subject, message);

    }

}

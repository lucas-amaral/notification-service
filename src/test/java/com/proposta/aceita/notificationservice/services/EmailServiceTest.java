package com.proposta.aceita.notificationservice.services;

import com.proposta.aceita.notificationservice.entities.Interest;
import com.proposta.aceita.notificationservice.entities.Negotiation;
import com.proposta.aceita.notificationservice.entities.Sale;
import com.proposta.aceita.notificationservice.entities.User;
import com.proposta.aceita.notificationservice.services.integrations.CrmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.Map;

import static org.mockito.Mockito.*;

@SpringBootTest
public class EmailServiceTest {

    @MockBean
    private SendGridEmailService sendGridEmailService;

    @MockBean
    private TemplateService templateService;

    @MockBean
    private CrmService crmService;

    private EmailService emailService;

    @BeforeEach
    public void setup() {
        emailService = new EmailService(sendGridEmailService, templateService, crmService);
    }

    @Test
    public void sendMatchEmailForSeller() {
        var propertyId = 32;

        var sale = new Sale(2, propertyId, null, null, null, null, null, null, false, false, false, false, null, false, null, false, null, false, null);
        var negotiation = new Negotiation("23-243-1das-112", null, sale, null);

        var user = new User("test", "test@test.com");

        var message = "{message body}";

        when(crmService.getUserByProperty(propertyId)).thenReturn(Optional.of(user));
        when(templateService.process("matchEmail", Map.of("name", user.getName()))).thenReturn(message);

        emailService.sendMatchEmailForSeller(negotiation);

        verify(sendGridEmailService).sendHTML("propostaceita+contato@gmail.com",
                "test@test.com",
                "Você possui uma nova proposta",
                message);
    }

    @Test
    public void sendMatchEmailForSellerWithNoUser() {
        var propertyId = 32;

        var sale = new Sale(2, propertyId, null, null, null, null, null, null, false, false, false, false, null, false, null, false, null, false, null);
        var negotiation = new Negotiation("23-243-1das-112", null, sale, null);

        when(crmService.getUserByProperty(propertyId)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class,
                () -> emailService.sendMatchEmailForSeller(negotiation));


        verifyNoInteractions(sendGridEmailService, templateService);
    }

    @Test
    public void sendMatchEmailForBuyer() {
        var interestId = 2;

        var user = new User("test", "test@test.com");
        var interest = new Interest(interestId,  null, null, null, null, null, null, null, null, null, null, null, false, null, null);
        var negotiation = new Negotiation("23-243-1das-112", interest, null, null);


        var message = "{message body}";

        when(crmService.getUserByInterest(interestId)).thenReturn(Optional.of(user));
        when(templateService.process("propertyEmail", Map.of("name", user.getName()))).thenReturn(message);

        emailService.sendMatchEmailForBuyer(negotiation);

        verify(sendGridEmailService).sendHTML("propostaceita+contato@gmail.com",
                "test@test.com",
                "Você possui uma novo imóvel para avaliar",
                message);
    }


    @Test
    public void sendMatchEmailForBuyerWithNoUser() {
        var interestId = 2;

        var interest = new Interest(interestId,  null, null, null, null, null, null, null, null, null, null, null, false, null, null);
        var negotiation = new Negotiation("23-243-1das-112", interest, null, null);

        when(crmService.getUserByProperty(interestId)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class,
                () -> emailService.sendMatchEmailForBuyer(negotiation));


        verifyNoInteractions(sendGridEmailService, templateService);
    }

    @Test
    public void sendDealEmail() {
        var negotiation = new Negotiation("23-243-1das-112", null, null, null);


        var message = "{message body}";

        when(templateService.process("dealEmail", Map.of("negotiationId", negotiation.getId()))).thenReturn(message);

        emailService.sendDealEmail(negotiation);

        verify(sendGridEmailService).sendHTML("propostaceita+contato@gmail.com",
                "propostaceita@gmail.com",
                "Finalização de compra",
                message);
    }
}

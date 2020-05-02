package com.proposta.aceita.notificationservice.services;

import com.sendgrid.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendGridEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendGridEmailService.class);

    private final SendGrid sendGridClient;

    @Autowired
    public SendGridEmailService(SendGrid sendGridClient) {
        this.sendGridClient = sendGridClient;
    }

    public void sendText(String from, String to, String subject, String body) {

        Response response = sendEmail(from, to, subject, new Content("text/plain", body));

        LOGGER.info("Status Code: {}, Body: {}, Headers: {}", response.getStatusCode() , response.getBody(), response.getHeaders());
    }

    public void sendHTML(String from, String to, String subject, String body) {

        Response response = sendEmail(from, to, subject, new Content("text/html", body));

        LOGGER.info("Status Code: {}, Body: {}, Headers: {}", response.getStatusCode() , response.getBody(), response.getHeaders());

    }

    private Response sendEmail(String from, String to, String subject, Content content) {

        var mail = new Mail(new Email(from), subject, new Email(to), content);
        var request = new Request();

        try {

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            return sendGridClient.api(request);

        } catch (IOException ex) {
            LOGGER.error("Error to send email to: {}, subject: {}", to, subject);
            LOGGER.error(ex.getMessage());
            return null;
        }

    }
}

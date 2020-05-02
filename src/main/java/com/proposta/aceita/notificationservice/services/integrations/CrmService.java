package com.proposta.aceita.notificationservice.services.integrations;

import com.proposta.aceita.notificationservice.entities.User;
import com.proposta.aceita.notificationservice.services.integrations.clients.CrmClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class CrmService extends IntegrationService {

    @Value("${services.crm.username}")
    private String username;

    @Value("${services.crm.password}")
    private String password;

    private final CrmClient crmClient;

    private String authHeader;

    public CrmService(CrmClient crmClient) {
        this.crmClient = crmClient;
    }

    @PostConstruct
    void postConstruct() {
        final String auth = username + ":" + password;
        authHeader = "Basic " + Base64Utils.encodeToString(auth.getBytes());
    }

    public Optional<User> getBuyerEmail(Integer propertyId) {
        return crmClient.getUser(authHeader, propertyId);
    }
}
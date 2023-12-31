package com.proposta.aceita.notificationservice.services.integrations.clients;

import com.proposta.aceita.notificationservice.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "${services.crm.name}", url = "${services.crm.url}")
public interface CrmClient {

    @GetMapping("/internal/properties/{propertyId}/users")
    Optional<User> getUserByProperty(@RequestHeader("Authorization") String authHeader, @PathVariable Integer propertyId);

    @GetMapping("/internal/interests/{interestId}/users")
    Optional<User> getUserByInterest(@RequestHeader("Authorization") String authHeader, @PathVariable Integer interestId);

}

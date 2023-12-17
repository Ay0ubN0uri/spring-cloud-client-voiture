package com.a00n.springmicroservicevoiture.services;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.a00n.springmicroservicevoiture.entities.Client;

@FeignClient(name = "SERVICE-CLIENT")
public interface ClientService {
    @GetMapping(path = "/clients/{id}")
    public Client clientById(@PathVariable Long id);

    @GetMapping(path = "/clients")
    public List<Client> clients();
}

package com.a00n.springmicroserviceclient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.a00n.springmicroserviceclient.entities.Client;
import com.a00n.springmicroserviceclient.repositories.ClientRepository;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public Client findById(@PathVariable Long id) throws Exception {
        return this.clientRepository.findById(id).orElseThrow(() -> new Exception("Client not fould"));
    }
}

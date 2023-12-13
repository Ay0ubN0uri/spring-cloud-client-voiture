package com.a00n.springmicroservicevoiture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a00n.springmicroservicevoiture.entities.Voiture;
import com.a00n.springmicroservicevoiture.repositories.VoitureRepository;
import com.a00n.springmicroservicevoiture.services.ClientService;

@RestController
public class VoitureController {
    @Autowired
    VoitureRepository voitureRepository;
    @Autowired
    ClientService clientService;

    @GetMapping(value = "/voitures", produces = { "application/json" })
    public ResponseEntity<Object> findAll() {
        try {
            List<Voiture> voitures = voitureRepository.findAll();
            for (Voiture voiture : voitures) {
                if (voiture.getId_client() != null) {
                    voiture.setClient(clientService.clientById(voiture.getId_client()));
                }
            }
            return ResponseEntity.ok(voitures);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching voitures: " + e.getMessage());
        }
    }
}

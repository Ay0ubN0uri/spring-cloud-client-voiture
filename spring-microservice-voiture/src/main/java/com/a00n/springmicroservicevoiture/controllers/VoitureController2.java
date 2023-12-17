package com.a00n.springmicroservicevoiture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.a00n.springmicroservicevoiture.entities.Voiture;
import com.a00n.springmicroservicevoiture.repositories.VoitureRepository;
import com.a00n.springmicroservicevoiture.services.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class VoitureController2 {
    @Autowired
    VoitureRepository voitureRepository;
    @Autowired
    ClientService clientService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("voiture", new Voiture());
        model.addAttribute("voitures", getVoitures());
        model.addAttribute("clients", clientService.clients());
        return "index";
    }

    private List<Voiture> getVoitures() {
        List<Voiture> voitures = voitureRepository.findAll();
        for (Voiture voiture : voitures) {
            if (voiture.getId_client() != null) {
                voiture.setClient(clientService.clientById(voiture.getId_client()));
            }
        }
        return voitures;
    }

    @PostMapping("/voitures/create")
    public String createVoiture(Voiture voiture, Model model) {
        System.out.println("=========================");
        System.out.println(voiture);
        voitureRepository.save(voiture);
        model.addAttribute("voiture", new Voiture());
        model.addAttribute("voitures", getVoitures());
        model.addAttribute("clients", clientService.clients());
        return "index";
    }

    @PostMapping("/voitures/update")
    public String update(Voiture voiture, Model model) {
        System.out.println(voiture);
        voitureRepository.save(voiture);
        model.addAttribute("voiture", new Voiture());
        model.addAttribute("voitures", getVoitures());
        model.addAttribute("clients", clientService.clients());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        System.out.println(id);
        voitureRepository.deleteById(id);
        model.addAttribute("voiture", new Voiture());
        model.addAttribute("voitures", getVoitures());
        model.addAttribute("clients", clientService.clients());
        return "index";
    }

}

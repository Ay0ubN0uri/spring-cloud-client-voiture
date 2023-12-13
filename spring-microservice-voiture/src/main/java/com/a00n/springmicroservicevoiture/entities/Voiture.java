package com.a00n.springmicroservicevoiture.entities;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private String matricule;
    private String model;
    @JsonIgnore
    private Long id_client;
    @Transient
    @ManyToOne
    private Client client;
}
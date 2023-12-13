package com.a00n.springmicroservicevoiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.a00n.springmicroservicevoiture.entities.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}

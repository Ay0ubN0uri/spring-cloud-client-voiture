package com.a00n.springmicroservicevoiture;

import com.a00n.springmicroservicevoiture.entities.Client;
import com.a00n.springmicroservicevoiture.entities.Voiture;
import com.a00n.springmicroservicevoiture.repositories.VoitureRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.a00n.springmicroservicevoiture.services.ClientService;

@SpringBootApplication
@EnableFeignClients
public class SpringMicroserviceVoitureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceVoitureApplication.class, args);
	}

	@Bean
	CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
		return args -> {
			Client c1 = clientService.clientById(2L);
			System.out.println("=====================================");
			Client c2 = clientService.clientById(1L);
			System.out.println("**************************");
			System.out.println("Id est :" + c2.getId());
			System.out.println("Nom est :" + c2.getNom());
			System.out.println("**************************");
			System.out.println("**************************");
			System.out.println("Id est :" + c1.getId());
			System.out.println("Nom est :" + c1.getNom());
			System.out.println("Nom est :" + c1.getAge());
			System.out.println("**************************");
			voitureRepository.save(new Voiture(0L, "Toyota", "A25 333", "Corolla", 1L, c2));
			voitureRepository.save(new Voiture(0L, "Renault", "B 6 3456", "Megane", 1L, c2));
			voitureRepository.save(new Voiture(0L, "Peugeot", "A 55 4444", "301", 2L, c1));
		};
	}
}

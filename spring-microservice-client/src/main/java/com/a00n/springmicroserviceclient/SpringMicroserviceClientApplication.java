package com.a00n.springmicroserviceclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.a00n.springmicroserviceclient.entities.Client;
import com.a00n.springmicroserviceclient.repositories.ClientRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringMicroserviceClientApplication {
	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceClientApplication.class, args);
	}

	@Bean
	public CommandLineRunner a00n() {
		return args -> {
			clientRepository.save(Client.builder().nom("asdf").age(Float.parseFloat("19")).build());
			clientRepository.save(Client.builder().nom("nouri").age(Float.parseFloat("19")).build());
			clientRepository.save(Client.builder().nom("kali").age(Float.parseFloat("19")).build());
			// var c = new Client(0L, "ayoub", 10);
			// clientRepository.save(c);
			// clientRepository.save(Client.builder().nom("ayoub").age(Float.parseFloat("23")).build());
			// clientRepository.save(Client.builder().nom("nouri").age(Float.parseFloat("23")).build());
			// clientRepository.save(Client.builder().nom("kali").age(Float.parseFloat("23")).build());
		};
	}

}

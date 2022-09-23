package com.example.projetpfe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.example.projetpfe.model.Utilisateur;
import com.example.projetpfe.repository.AuteurRepository;
import com.example.projetpfe.repository.UserRepository;
import com.example.projetpfe.service.AuthService;


@SpringBootApplication()

public class ProjetPfeApplication implements CommandLineRunner {
	
	@Autowired
	AuteurRepository auteurRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetPfeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
			
		
	}

}

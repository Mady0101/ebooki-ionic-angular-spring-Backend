package com.example.projetpfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetpfe.model.Auteur;
import com.example.projetpfe.service.AuteurService;

@CrossOrigin
@RestController
@RequestMapping("/auteur")
public class AuteurController {
	@Autowired AuteurService auteurService;
	@PostMapping("/add")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Auteur addAuteur(@RequestBody Auteur auteur) {
		
		return auteurService.addAuteur(auteur);
	}
	
	@GetMapping("/find/{nom}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Auteur findbyNom(@PathVariable String nom) {
		return auteurService.findbyNom(nom);
	}

}

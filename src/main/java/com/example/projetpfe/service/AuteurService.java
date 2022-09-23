package com.example.projetpfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetpfe.model.Auteur;
import com.example.projetpfe.repository.AuteurRepository;

@Service
public class AuteurService {
	@Autowired AuteurRepository auteurRepository;
	public Auteur addAuteur(Auteur auteur) {
		if(findbyNom(auteur.getNom())==null)
		return auteurRepository.save(auteur);
		else
		return null;
	}
	
	public Auteur findbyNom(String nom) {
		return auteurRepository.findByNom(nom);
	}

}

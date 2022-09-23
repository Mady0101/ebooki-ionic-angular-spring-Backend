package com.example.projetpfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetpfe.model.Theme;
import com.example.projetpfe.repository.ThemeRepository;
@Service
public class ThemeService {
	@Autowired ThemeRepository ThemeRepository;
	public Theme addTheme(Theme theme) {
		if(ThemeRepository.findByNom(theme.getNom())==null)
		return ThemeRepository.save(theme);
		else
		return null;
	}
	
	public Theme findbyNom(String nom) {
		return ThemeRepository.findByNom(nom);
	}


}

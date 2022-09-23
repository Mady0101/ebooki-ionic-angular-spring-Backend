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

import com.example.projetpfe.model.Theme;
import com.example.projetpfe.service.ThemeService;

@CrossOrigin
@RestController
@RequestMapping("/theme")
public class ThemeController {
	@Autowired ThemeService ThemeService;
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public Theme addTheme(@RequestBody Theme theme) {
		
		return ThemeService.addTheme(theme);
	}
	
	@GetMapping("/find/{nom}")
	@PreAuthorize("hasRole('ADMIN')")
	public Theme findbyNom(@PathVariable String nom) {
		return ThemeService.findbyNom(nom);
	}

}

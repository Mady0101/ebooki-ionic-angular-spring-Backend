package com.example.projetpfe.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetpfe.model.Livre;
import com.example.projetpfe.model.Theme;
import com.example.projetpfe.model.Auteur;
import com.example.projetpfe.repository.AuteurRepository;
import com.example.projetpfe.repository.LivreRepository;
import com.example.projetpfe.repository.ThemeRepository;

@Service
public class LivreService {
	
	@Autowired
	LivreRepository livreRepository;
	
	@Autowired
	ThemeRepository themeRepository;
	
	@Autowired
	AuteurRepository auteurRepository;

	
	
	public void addLivre(Livre livre) {
		livreRepository.save(livre);
		
	}
	
	public void updateLivreVues(Long livreid) {
		livreRepository.updateLivreVues(livreid);
	}
	
	
	
	public List<Livre> getAllLivres(){
		return(livreRepository.findAll());
		}
	
	public Optional<Livre> getLivre(Long id) {
		return(livreRepository.findById(id));
	}
	
	public void deleteLivre(Long id) {
		livreRepository.deleteById(id);
	}
	
	public void updateLivreImg(Long id , String Img) {
		livreRepository.updateLivreImg(id, Img);
	}
	
	public void updateLivreJaimes(Long id, int jaimes) {
		livreRepository.updateLivreJaimes(id, jaimes);
	}
	
	public String getPdfById(Long id) {
		return livreRepository.getPdfById(id);
	}
	
	public Set<Livre> getLivreMostVues(){
		return livreRepository.getLivreMostVues();
	}
	
	public Set<Livre> getLivreMostLikes(){
		return livreRepository.getLivreMostLikes();
	}
	
	public void updateLivre(Livre livre) {
		if(auteurRepository.findByNom(livre.getAuteur().getNom())==null) {
			Auteur auteur = new Auteur() ;
			auteur.setNom(livre.getAuteur().getNom());
			Auteur createdAuteur = auteurRepository.save(auteur);
			livre.setAuteur(createdAuteur);
		}else
			livre.setAuteur(auteurRepository.findByNom(livre.getAuteur().getNom()));
		
		if(themeRepository.findByNom(livre.getTheme().getNom())==null) {
			Theme theme = new Theme() ;
			theme.setNom(livre.getAuteur().getNom());
			Theme createdTheme = themeRepository.save(theme);
			livre.setTheme(createdTheme);
		}else
			livre.setTheme(themeRepository.findByNom(livre.getTheme().getNom()));
			
		livreRepository.save(livre);
	}
	
	
	public void addAuteur(Auteur auteur) {
		auteurRepository.save(auteur);
	}
	public void addTheme(Theme theme) {
		themeRepository.save(theme);
	}
}

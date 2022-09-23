package com.example.projetpfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetpfe.model.Jaimes;
import com.example.projetpfe.model.Livre;
import com.example.projetpfe.model.Utilisateur;
import com.example.projetpfe.repository.JaimesRepository;

@Service
public class JaimesService {
	
	@Autowired
	JaimesRepository jaimesRepository;
	
	public int isLiked(Long userid, Long livreid) {
		return jaimesRepository.isLiked(userid, livreid);
	}
	
	public void deleteJaime(Long userid, Long livreid) {
		jaimesRepository.deleteByUserLivre(userid, livreid);
	}
	
	public void addJaime(Long userid, Long livreid) {
		Jaimes jaime=new Jaimes();
		Utilisateur utilisateur=new Utilisateur();
		utilisateur.setUserId(userid);
		Livre livre=new Livre();
		livre.setLivreId(livreid);
		jaime.setUtilisateur(utilisateur);
		jaime.setLivre(livre);
		jaimesRepository.save(jaime);
	}
	

}

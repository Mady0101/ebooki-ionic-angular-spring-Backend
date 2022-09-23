package com.example.projetpfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.projetpfe.model.Livre;
import com.example.projetpfe.model.Utilisateur;
import com.example.projetpfe.model.Vues;
import com.example.projetpfe.repository.VuesRepository;

@Service
public class VuesService {
	
	@Autowired
	VuesRepository vuesRepository;
	
	public int isVued(Long userid, Long livreid) {
		return vuesRepository.isVued(userid, livreid);
	}
	
	
	public void addVue(Long userid, Long livreid) {
		Vues vue=new Vues();
		Utilisateur utilisateur=new Utilisateur();
		utilisateur.setUserId(userid);
		Livre livre=new Livre();
		livre.setLivreId(livreid);
		vue.setUtilisateur(utilisateur);
		vue.setLivre(livre);
		vuesRepository.save(vue);
	}

}

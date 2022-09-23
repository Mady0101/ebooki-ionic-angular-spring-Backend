package com.example.projetpfe.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.projetpfe.model.Livre_abonner;
import com.example.projetpfe.repository.Livre_abonnerRepository;

@Service
public class Livre_abonnerService {
   
	@Autowired
	Livre_abonnerRepository livre_abonnerRepository;
	
	public Set<Livre_abonner> findLivreAbonnerByUserId(Long userid) {
		return livre_abonnerRepository.findLivreAbonnerByUserId(userid);
	}
	
	public String addLivreAbonner(Livre_abonner livreAbonner) {
		if(livre_abonnerRepository.exist(livreAbonner.getUtilisateur().getUserId(), livreAbonner.getLivre().getLivreId()) == null)
		{
			livre_abonnerRepository.save(livreAbonner);
		    return("succes");
		}
		else
			return("exist déja");
		
		
	}
	
	public void updateMarker(int pageMarked ,float completion,boolean finished ,Long abonnerid) {
		livre_abonnerRepository.updateMarker(pageMarked,completion,finished, abonnerid);
	}
	
	public Livre_abonner getMarker(Long abonnerid) {
		return livre_abonnerRepository.getMarker(abonnerid);
	}
	
	public Optional<Livre_abonner> getLivreAbonnerById(Long abonnerId) {
		return livre_abonnerRepository.findById(abonnerId);
	}
	
	public void updateLivreAbonner(Livre_abonner livreAbonner) {
		livre_abonnerRepository.save(livreAbonner);
	}
	public void deleteLivreAbonner(Long livreAbonnerId) {
		livre_abonnerRepository.deleteById(livreAbonnerId);
	}
}

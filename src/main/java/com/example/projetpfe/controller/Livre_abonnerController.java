package com.example.projetpfe.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.projetpfe.model.Livre_abonner;
import com.example.projetpfe.model.Response_entity_msg;
import com.example.projetpfe.service.Livre_abonnerService;

@CrossOrigin
@RestController
@RequestMapping("/abonner")
public class Livre_abonnerController {
	
	@Autowired
	Livre_abonnerService livre_abonnerService;
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Response_entity_msg> addLivreAbonner(@RequestBody Livre_abonner livreAbonner) {
		String msg = livre_abonnerService.addLivreAbonner(livreAbonner);
		return new ResponseEntity<Response_entity_msg>(new Response_entity_msg(msg),
				                  new HttpHeaders(),
				                  HttpStatus.OK);
	}
	
	@GetMapping("/find/user/{userid}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Set<Livre_abonner> findLivreAbonnerByUserId (@PathVariable Long userid){
		return livre_abonnerService.findLivreAbonnerByUserId(userid);
	}
	
	@GetMapping("/find/{abonnerId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Optional<Livre_abonner> getLivreAbonnerById(@PathVariable Long abonnerId) {
		return livre_abonnerService.getLivreAbonnerById(abonnerId);
	}
	
	@PutMapping("/update/Marker")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void updateMarker (@RequestBody Livre_abonner livreAbonner) {
		
		livre_abonnerService.updateMarker(livreAbonner.getPageMarked(),livreAbonner.getCompletion(),livreAbonner.isFinished(), livreAbonner.getAbonneId());
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void updateTimer(@RequestBody Livre_abonner livreAbonner) {
		livre_abonnerService.updateLivreAbonner(livreAbonner);
	}
	
	@GetMapping("/get/Marker/{abonnerid}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Livre_abonner> getMarker(@PathVariable Long abonnerid){
		return(new ResponseEntity<Livre_abonner>(livre_abonnerService.getMarker(abonnerid),
				                  new HttpHeaders(),
				                  HttpStatus.OK));
	}
	
	@DeleteMapping("/delete/{abonnerId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void deleteLivreAbonne(@PathVariable Long abonnerId) {
		livre_abonnerService.deleteLivreAbonner(abonnerId);
	}

}

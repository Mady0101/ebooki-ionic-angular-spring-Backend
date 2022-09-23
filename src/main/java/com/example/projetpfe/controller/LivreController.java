package com.example.projetpfe.controller;

import java.util.List;
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

import com.example.projetpfe.model.Livre;
import com.example.projetpfe.model.responseMessage;
import com.example.projetpfe.repository.AuteurRepository;
import com.example.projetpfe.service.JaimesService;
import com.example.projetpfe.service.LivreService;
import com.example.projetpfe.service.VuesService;
@CrossOrigin
@RestController
@RequestMapping("/livre")
public class LivreController {
	
	@Autowired
	LivreService livreService;
	@Autowired
	JaimesService jaimesService;
	@Autowired
	VuesService vuesService;
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public void addLivre(@RequestBody Livre livre) {
		livreService.addLivre(livre);
	}
	
	@GetMapping("/find/pdf/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String getPdfById(@PathVariable Long id){
		String pdf = livreService.getPdfById(id);
		return(pdf);
	}
	
	@GetMapping("/find/most/likes")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Set<Livre> getLivreMostLikes(){
		return livreService.getLivreMostLikes();
	}
	
	@GetMapping("/find/most/vues")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Set<Livre> getLivreMostVues(){
		return livreService.getLivreMostVues();
	}
	
	@GetMapping("/find/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Optional<Livre> getLivre(@PathVariable Long id) {
		return(livreService.getLivre(id));
	}
	
	@GetMapping("/find")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Livre> getAllLivre(){
		return(livreService.getAllLivres());
	}
	
	
	
	@PutMapping("/update/img")
	@PreAuthorize("hasRole('ADMIN')")
	public void updateLivreImg(@RequestBody Livre livre) {
		livreService.updateLivreImg(livre.getLivreId(), livre.getImg());
	}
	
	@PutMapping("/update/jaimes/{userid}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<responseMessage> updateLivreJaimes(@PathVariable Long userid, @RequestBody Livre livre) {
		if(jaimesService.isLiked(userid, livre.getLivreId())==0) {
		jaimesService.addJaime(userid, livre.getLivreId());
		livreService.updateLivreJaimes(livre.getLivreId(), livre.getJaimes()+1);
		return new ResponseEntity<responseMessage>(new responseMessage("incrementer"),new HttpHeaders(),HttpStatus.OK);
		}
		else {
		jaimesService.deleteJaime(userid, livre.getLivreId());
		livreService.updateLivreJaimes(livre.getLivreId(), livre.getJaimes()-1);
		return new ResponseEntity<responseMessage>(new responseMessage("decrementer"),new HttpHeaders(),HttpStatus.OK);
		}
		
	}
	
	@PutMapping("/update/vues/{userid}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void updateLivreVues(@PathVariable Long userid, @RequestBody Livre livre) {
		if(vuesService.isVued(userid, livre.getLivreId())==0) {
		vuesService.addVue(userid, livre.getLivreId());
		livreService.updateLivreVues(livre.getLivreId());
		}
	}
	
	@GetMapping("isLiked/{userid}/{livreid}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public boolean isLiked(@PathVariable Long userid,@PathVariable Long livreid) {
		boolean isLiked ;
		if(jaimesService.isLiked(userid, livreid)==1)
			isLiked=true;
		else
			isLiked=false;
		return isLiked;
	}
	
	@GetMapping("isVued/{userid}/{livreid}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public boolean isVued(@PathVariable Long userid,@PathVariable Long livreid) {
		boolean isVued ;
		if(vuesService.isVued(userid, livreid)==1)
			isVued=true;
		else
			isVued=false;
		return isVued;
	}
	
	@DeleteMapping("/delete/{livreid}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteLivre(@PathVariable Long livreid) {
		livreService.deleteLivre(livreid);
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	public void updateLivre(@RequestBody Livre livre) {
		
		livreService.updateLivre(livre);
	}

}

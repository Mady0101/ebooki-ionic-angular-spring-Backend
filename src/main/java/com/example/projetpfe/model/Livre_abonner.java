package com.example.projetpfe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="livre_abonner")
public class Livre_abonner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long abonneId;
	
	@ManyToOne
	@JoinColumn(name="userId",nullable=false)
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="livreId",nullable=false)
	private Livre livre ;
	
	private int pageMarked; 
	
	private float completion;
	
	private boolean finished;
	
	private int timer;
	
	

	public Livre_abonner() {
		super();
	}

	public Livre_abonner(Long abonneId, Utilisateur utilisateur, Livre livre) {
		super();
		this.abonneId = abonneId;
		this.utilisateur = utilisateur;
		this.livre = livre;
	}
	
	
	
	
    
	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public float getCompletion() {
		return completion;
	}

	public void setCompletion(float completion) {
		this.completion = completion;
	}

	public int getPageMarked() {
		return pageMarked;
	}

	public void setPageMarked(int pageMarked) {
		this.pageMarked = pageMarked;
	}

	public Long getAbonneId() {
		return abonneId;
	}

	public void setAbonneId(Long abonneId) {
		this.abonneId = abonneId;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	
	
	
	
}
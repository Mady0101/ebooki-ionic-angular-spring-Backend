package com.example.projetpfe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="jaimes")
public class Jaimes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jaimesId ;
	
	@ManyToOne
	@JoinColumn(name="userId",nullable=false)
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="livreId",nullable=false)
	private Livre livre ;
	
	
	public Jaimes() {
		super();
	}
	
	

	public Long getJaimesId() {
		return jaimesId;
	}
	public void setJaimesId(Long jaimesId) {
		this.jaimesId = jaimesId;
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

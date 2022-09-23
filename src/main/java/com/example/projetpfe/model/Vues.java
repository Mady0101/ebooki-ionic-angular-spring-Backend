package com.example.projetpfe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="vues")
public class Vues {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vueId ;
	
	@ManyToOne
	@JoinColumn(name="userId",nullable=false)
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="livreId",nullable=false)
	private Livre livre ;
	
	public Vues() {
		super();
	}
	public Long getVueId() {
		return vueId;
	}
	public void setVueId(Long vueId) {
		this.vueId = vueId;
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

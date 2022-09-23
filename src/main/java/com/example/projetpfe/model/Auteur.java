package com.example.projetpfe.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="auteur")
public class Auteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long auteurId;
	@NotBlank(message = "Name is required")
	private String nom;
	@OneToMany(mappedBy="auteur" , cascade = CascadeType.REMOVE)
	private Set<Livre> list_livre;
	public Auteur() {
		super();
	}
	public Auteur(Long auteurId, String nom) {
		super();
		this.auteurId = auteurId;
		this.nom = nom;
	}
	public Long getAuteurId() {
		return auteurId;
	}
	public void setAuteurId(Long auteurId) {
		this.auteurId = auteurId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	

}

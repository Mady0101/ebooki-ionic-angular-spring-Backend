package com.example.projetpfe.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="livre")
public class Livre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long livreId;
	@NotBlank(message = "Name is required")
	private String nom;
	@ManyToOne
	@JoinColumn(name="themeId",nullable=false)
	private Theme theme;
	@ManyToOne
	@JoinColumn(name="AuteurId",nullable=false)
	private Auteur auteur;
	private int vues;
	private int jaimes;
	private String img;
	private String description;
	@OneToMany(mappedBy="livre" , cascade = CascadeType.REMOVE)
	private Set<Comment> comments;
	@OneToMany(mappedBy="livre" , cascade = CascadeType.REMOVE)
	private Set<Jaimes> table_jaimes;
	@OneToMany(mappedBy="livre" , cascade = CascadeType.REMOVE)
	private Set<Vues> table_vues;
	
	@OneToMany(mappedBy="livre" , cascade = CascadeType.REMOVE)
	private Set<Livre_abonner> livre_abonner;
	private String pdf;
	

	
	public Livre(Long livreId, String nom, Theme theme, Auteur auteur, int vues, int jaimes, String img , String pdf) {
		super();
		
		this.livreId = livreId;
		this.nom = nom;
		this.theme = theme;
		this.auteur = auteur;
		this.vues = vues;
		this.jaimes = jaimes;
		this.img = img;
		this.pdf=pdf;
	}
	
	public Livre() {
		super();
	}
	
	

	
    
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public Long getLivreId() {
		return livreId;
	}
	public void setLivreId(Long livreId) {
		this.livreId = livreId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public int getVues() {
		return vues;
	}
	public void setVues(int vues) {
		this.vues = vues;
	}
	public int getJaimes() {
		return jaimes;
	}
	public void setJaimes(int jaimes) {
		this.jaimes = jaimes;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
    
}

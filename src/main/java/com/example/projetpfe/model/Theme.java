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
@Table(name="theme")
public class Theme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ThemeId;
	@NotBlank(message = "Name is required")
	private String nom;
	@OneToMany(mappedBy="theme" , cascade = CascadeType.REMOVE)
	private Set<Livre> list_livre;
	public Theme() {
		super();
	}
	public Theme(Long themeId, @NotBlank(message = "Name is required") String nom) {
		super();
		ThemeId = themeId;
		this.nom = nom;
	}
	public Long getThemeId() {
		return ThemeId;
	}
	public void setThemeId(Long themeId) {
		ThemeId = themeId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}

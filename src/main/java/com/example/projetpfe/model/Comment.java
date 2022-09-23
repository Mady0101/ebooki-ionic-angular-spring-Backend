package com.example.projetpfe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId ;
	@NotBlank(message="content is required")
	private String content;
	@ManyToOne
	@JoinColumn(name="userId",nullable=false)
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="livreId",nullable=false)
	private Livre livre ;
	
	
	public Comment() {
		super();
	}
	public Comment(Long commentId, @NotBlank(message = "content is required") String content, Utilisateur utilisateur,
			Livre livre) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.utilisateur = utilisateur;
		this.livre = livre;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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

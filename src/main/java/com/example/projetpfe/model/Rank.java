package com.example.projetpfe.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="rank")
public class Rank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rankId;
	@NotBlank(message = "Name is required")
	private String name;
	
	private int rankcap ;
	
	private Long nextRankId;
	@OneToMany(mappedBy="rank")
	private Set<Utilisateur> user;
	
	public Rank() {
		super();
	}
	public Rank(Long rankId) {
		super();
		this.rankId=rankId;
	}
	public Long getRankId() {
		return rankId;
	}
	public void setRankId(Long rankId) {
		this.rankId = rankId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRankcap() {
		return rankcap;
	}
	public void setRankcap(int rankCap) {
		this.rankcap = rankCap;
	}
	public Long getNextRankId() {
		return nextRankId;
	}
	public void setNextRankId(Long nextRankId) {
		this.nextRankId = nextRankId;
	}
	
	

}

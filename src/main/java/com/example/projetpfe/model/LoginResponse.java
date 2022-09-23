package com.example.projetpfe.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class LoginResponse {
	
	
	private String jwt;
	private Long userId;
	private String username;
	private String email;
    private Date birthday;
	private Rank rank;
	private String profile_img;
	
	private int exp;
	private List<String> roles;
	public LoginResponse(String jwt, Long id,String username, String email,Date birthday, String profile_img, int exp,Rank rank, List<String> roles) {
		super();
		this.username=username;
		this.jwt = jwt;
		this.userId = id;
		this.email = email;
		this.birthday = birthday;
		this.profile_img=profile_img;
		this.exp=exp;
		this.rank = rank;
		this.roles = roles;
	}
	
	
	
	
	public Rank getRank() {
		return rank;
	}




	public void setRank(Rank rank) {
		this.rank = rank;
	}




	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long id) {
		this.userId = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getProfile_img() {
		return profile_img;
	}


	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}


	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}
	
	
	
	

}

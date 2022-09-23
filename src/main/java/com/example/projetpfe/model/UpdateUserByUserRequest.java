package com.example.projetpfe.model;

public class UpdateUserByUserRequest {
	Utilisateur user;
	String oldPassword;
	
	
	public UpdateUserByUserRequest() {
		super();
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	

}

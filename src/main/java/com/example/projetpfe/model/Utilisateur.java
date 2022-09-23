package com.example.projetpfe.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "utilisateur")
public class Utilisateur  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	@NotBlank(message = "Username is required")
	private String username;
	@NotBlank(message = "Password is required")
	private String password;
	
	private String profile_img;
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Your birthday is required")
	private Date birthday;
	@Email
    @NotEmpty(message = "Email is required")
	private String email;
	@OneToMany(mappedBy="utilisateur" , cascade = CascadeType.REMOVE)
	private Set<Comment> comments;
	
	@OneToMany(mappedBy="utilisateur" , cascade = CascadeType.REMOVE)
	private Set<Jaimes> jaimes;
	
	@OneToMany(mappedBy="utilisateur" , cascade = CascadeType.REMOVE)
	private Set<Vues> vues;
	
	@OneToMany(mappedBy="utilisateur" , cascade = CascadeType.REMOVE)
	private Set<Livre_abonner> livre_abonner;
	
	private int exp;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
			    joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id")
				)
	private Set<Role> roles = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="rank_id")
	@NotFound( action = NotFoundAction.IGNORE )
	private Rank rank = new Rank((long) 133);
	
	
	
	
	
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(Long userId, String username, String password, String profile_img, Date birthday, String email, Rank rank) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.profile_img = profile_img;
		this.birthday = birthday;
		this.email = email;
		this.rank = rank;
	}
	
	

	

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
	
	
	
	

}

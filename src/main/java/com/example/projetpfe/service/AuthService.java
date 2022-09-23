package com.example.projetpfe.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetpfe.model.AddUserRequest;
import com.example.projetpfe.model.ERole;
import com.example.projetpfe.model.Rank;
import com.example.projetpfe.model.Role;
import com.example.projetpfe.model.SignUpRequest;
import com.example.projetpfe.model.UpdateUserByUserRequest;
import com.example.projetpfe.model.Utilisateur;
import com.example.projetpfe.repository.UserRepository;
import com.example.projetpfe.repository.RoleRepository;
import com.example.projetpfe.repository.RankRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class AuthService  {
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	RankRepository rankRepository;
	
	public String signUp(SignUpRequest user) {
		if (userRepository.existsByUsername(user.getUsername())) {
			return "Error: Username is already taken!";
		}

		if (userRepository.existsByEmail(user.getEmail())) {
			return "Error: Email is already in use!";
		}
		Utilisateur signedUser = new Utilisateur();
		
		signedUser.setBirthday(user.getBirthday());
		signedUser.setEmail(user.getEmail());
		signedUser.setPassword(encoder.encode(user.getPassword()));
		signedUser.setUsername(user.getUsername());
		Set<String> strRoles = user.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		signedUser.setRoles(roles);
		
		userRepository.save(signedUser);
		return "User registered successfully!";
		
	}
	
	public Utilisateur login(String username, String password) {
		Utilisateur user = userRepository.login(username, password);
		return(user);
		
	}
	
	public Optional<Utilisateur> getUserById(Long userId) {
		return userRepository.findById(userId);
	}
	
	public String UpdateUserByUserr(UpdateUserByUserRequest user) {
		//userRepository.updateUserById(user.getEmail(), user.getPassword(), user.getProfile_img(), user.getBirthday(), user.getUserId());
		  String userPassword = userRepository.getUserPassword(user.getUser().getUserId());
		  if (encoder.matches(user.getOldPassword(), userPassword)) {
		  if(user.getUser().getPassword()=="")
			  user.getUser().setPassword(userPassword);
		  else
		      user.getUser().setPassword(encoder.encode(user.getUser().getPassword()));
	      userRepository.save(user.getUser());
	      return "Updated Succefully";
		  }else
			  return "Your current password was inccorect";
	      }
	
	public String updateUserByAdmin(AddUserRequest user, Long userid) {
		Optional<Utilisateur> userToUpdate;
		userToUpdate = userRepository.findById(userid);
		if(!userToUpdate.get().getUsername().equals(user.getUsername())) {
		if (userRepository.existsByUsername(user.getUsername())) {
			return "Error: Username is already taken!";
		}}
        if(!userToUpdate.get().getEmail().equals(user.getEmail())) {
		if (userRepository.existsByEmail(user.getEmail())) {
			return "Error: Email is already in use!";
		}}
		Utilisateur updatedUser = new Utilisateur();
		
		updatedUser.setBirthday(user.getBirthday());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setPassword(encoder.encode(user.getPassword()));
		updatedUser.setUsername(user.getUsername());
		updatedUser.setExp(user.getExp());
		if (user.getExp() < 50400)
			updatedUser.setRank(new Rank((long)133));
	    else if(user.getExp() >= 50400 && user.getExp() < 136800)
	    	updatedUser.setRank(new Rank((long)134));
		else if(user.getExp() >= 136800 && user.getExp() < 352800)
			updatedUser.setRank(new Rank((long)135));
		else 
			updatedUser.setRank(new Rank((long)136));
		Set<String> strRoles = user.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		updatedUser.setRoles(roles);
		updatedUser.setUserId(userid);
		
		userRepository.save(updatedUser);
		return "User updated successfully!";
		
	}
	
	public void updateUserExpById(int exp, Long userid , Rank rank) {
		userRepository.updateUserExpById(exp, userid);
		if(rank.getName() != "Expert") {
		if(exp >= rank.getRankcap()) {
			userRepository.updateUserRankById(rank.getNextRankId(), userid);
		}}
		}
	
	public Optional<Rank> getRankbyId(Long rankId) {
		return rankRepository.findById(rankId);
	}
	
	public List<Utilisateur> getAllUsers(){
		return userRepository.findAll();
	}
	
	public void deleteUser(Long userid) {
		userRepository.deleteById(userid);
	}
	
	public Boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	public Boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
	
	
	public String add(AddUserRequest user) {
		if (userRepository.existsByUsername(user.getUsername())) {
			return "Error: Username is already taken!";
		}

		if (userRepository.existsByEmail(user.getEmail())) {
			return "Error: Email is already in use!";
		}
		Utilisateur signedUser = new Utilisateur();
		
		signedUser.setBirthday(user.getBirthday());
		signedUser.setEmail(user.getEmail());
		signedUser.setPassword(encoder.encode(user.getPassword()));
		signedUser.setUsername(user.getUsername());
		signedUser.setExp(user.getExp());
		if (user.getExp() < 50400)
			signedUser.setRank(new Rank((long)133));
	    else if(user.getExp() >= 50400 && user.getExp() < 136800)
	    	signedUser.setRank(new Rank((long)134));
		else if(user.getExp() >= 136800 && user.getExp() < 352800)
			signedUser.setRank(new Rank((long)135));
		else 
			signedUser.setRank(new Rank((long)136));
		Set<String> strRoles = user.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		signedUser.setRoles(roles);
		
		userRepository.save(signedUser);
		return "User registered successfully!";
	}
	

}

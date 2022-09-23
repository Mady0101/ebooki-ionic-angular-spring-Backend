package com.example.projetpfe.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.projetpfe.model.AddUserRequest;
import com.example.projetpfe.model.LoginResponse;
import com.example.projetpfe.model.Rank;
import com.example.projetpfe.model.Response_entity_msg;
import com.example.projetpfe.model.SignUpRequest;
import com.example.projetpfe.model.UpdateUserByUserRequest;
import com.example.projetpfe.model.Utilisateur;
import com.example.projetpfe.model.responseMessage;
import com.example.projetpfe.repository.UserRepository;
import com.example.projetpfe.service.AuthService;
import com.example.projetpfe.webSecurity.Service.UserDetailsImpl;
import com.example.projetpfe.webSecurity.jwt.JwtUtils;
@CrossOrigin
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
	@Autowired
	AuthService authservice;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	
	@Autowired
	JwtUtils jwtUtils;

	
	@PostMapping("/auth/signup")
	public ResponseEntity<responseMessage> signup(@RequestBody SignUpRequest user) {
		
		
		String msg= authservice.signUp(user);
		return new ResponseEntity<responseMessage>(new responseMessage(msg),new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@PostMapping("/auth/login")
	public ResponseEntity<LoginResponse>  login(@RequestBody Utilisateur loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		
		return ResponseEntity.ok(new LoginResponse(jwt, 
				 userDetails.getId(), 
				 userDetails.getUsername(), 
				 userDetails.getEmail(), 
				 userDetails.getBirthday(),
				 userDetails.getProfile_img(),
				 userDetails.getExp(),
				 userDetails.getRank(),
				 roles));
		
	}
	
	@GetMapping("/find/{userid}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Optional<Utilisateur> findByUserId(@PathVariable Long userid) {
		return(authservice.getUserById(userid));
	}
	
	@GetMapping("/find")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Utilisateur> getAllUsers(){
		return(authservice.getAllUsers());
	}
	
	@PutMapping("/updateByAdmin/{userid}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Response_entity_msg> updateUserByAdmin(@RequestBody AddUserRequest user , @PathVariable Long userid) {
		String msg=authservice.updateUserByAdmin(user,userid);
		return new ResponseEntity<Response_entity_msg>(new Response_entity_msg(msg),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/updateByUser")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<responseMessage> updateUserByUser(@RequestBody UpdateUserByUserRequest user) {
		String msg = authservice.UpdateUserByUserr(user);
		return new ResponseEntity<responseMessage>(new responseMessage(msg),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/update/exp")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void updateUserExpById(@RequestBody Utilisateur user) {
		
		authservice.updateUserExpById(user.getExp(), user.getUserId(), user.getRank());
	}
	
	@DeleteMapping("/delete/{userid}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUser(@PathVariable Long userid) {
		authservice.deleteUser(userid);
	}
	
	@GetMapping("/find/rank/{rankId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Optional<Rank> getRank(@PathVariable Long rankId) {
		return authservice.getRankbyId(rankId);
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Response_entity_msg> addUser(@RequestBody AddUserRequest user){
		
	    String msg=authservice.add(user);
		return new ResponseEntity<Response_entity_msg>(new Response_entity_msg(msg),new HttpHeaders(),HttpStatus.OK);
	}
	
	

}

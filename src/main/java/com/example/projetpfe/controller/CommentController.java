package com.example.projetpfe.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetpfe.model.Comment;
import com.example.projetpfe.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired 
	CommentService commentService;
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void addComment(@RequestBody Comment comment) {
		commentService.addComment(comment);
	}
	
	@GetMapping("/find/{livreid}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Set<Comment> findCommentsByLivre(@PathVariable Long livreid){
		return commentService.findCommentsByLivre(livreid);
	}
	
	@DeleteMapping("/delete/commentId")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void deleteComment(@PathVariable Long commentId) {
		commentService.deleteComment(commentId);
	}
   
}

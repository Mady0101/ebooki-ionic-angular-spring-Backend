package com.example.projetpfe.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetpfe.model.Comment;
import com.example.projetpfe.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	public Set<Comment> findCommentsByLivre (Long livreid) {
		return commentRepository.findCommentsByLivre(livreid);
	}
	
	public void addComment(Comment comment) {
		commentRepository.save(comment);
		
	}
	
	public void deleteComment(Long commentId) {
		commentRepository.deleteById(commentId);
	}

}

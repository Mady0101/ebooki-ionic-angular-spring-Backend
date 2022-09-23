package com.example.projetpfe.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projetpfe.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>  {
	
	@Query(value="SELECT * FROM comment c where c.livre_id=:livreid", nativeQuery=true)
	public Set<Comment> findCommentsByLivre (@Param("livreid") Long livreid);

}

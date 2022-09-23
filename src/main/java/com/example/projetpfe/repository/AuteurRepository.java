package com.example.projetpfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projetpfe.model.Auteur;
@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {
	
	@Query(value="select * from auteur u where u.nom=:nom",nativeQuery=true)
	public  Auteur findByNom(@Param("nom")String nom);

}

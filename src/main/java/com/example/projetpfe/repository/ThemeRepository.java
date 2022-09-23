package com.example.projetpfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.projetpfe.model.Theme;
@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long>{
	
	@Query(value="select * from theme u where u.nom=:nom",nativeQuery=true)
	public  Theme findByNom(@Param("nom")String nom);

}

package com.example.projetpfe.repository;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projetpfe.model.Livre;
@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {
	@Modifying
	@Transactional
	@Query(value="UPDATE livre SET img = :img where livre_id= :id", nativeQuery=true)
	public void updateLivreImg(@Param("id") Long id , @Param("img") String img);
    
	@Modifying
	@Transactional
	@Query(value="UPDATE livre SET jaimes= :jaimes where livre_id= :id", nativeQuery=true)
	public void updateLivreJaimes(@Param("id") Long id, @Param("jaimes") int jaimes);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE livre SET vues= vues+1 where livre_id= :id", nativeQuery=true)
	public void updateLivreVues(@Param("id") Long id);
	
	
	
	@Query(value="SELECT pdf FROM livre u where livre_id= :id", nativeQuery=true)
	public String getPdfById(@Param("id") Long id);
	
	@Query(value="SELECT * FROM livre u ORDER BY u.vues DESC LIMIT 10", nativeQuery=true)
	public Set<Livre> getLivreMostVues();
	
	@Query(value="SELECT * FROM livre u ORDER BY u.jaimes DESC LIMIT 10", nativeQuery=true)
	public Set<Livre> getLivreMostLikes();
}

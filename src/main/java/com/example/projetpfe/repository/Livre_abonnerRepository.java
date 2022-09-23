package com.example.projetpfe.repository;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projetpfe.model.Livre_abonner;


@Repository
public interface Livre_abonnerRepository extends JpaRepository<Livre_abonner, Long> {
	
	@Query (value="SELECT * FROM livre_abonner u where user_id= :userid " , nativeQuery=true)
	public Set<Livre_abonner> findLivreAbonnerByUserId(@Param("userid") Long userid);
	
	@Query (value="SELECT * FROM livre_abonner u where user_id= :userid AND livre_id= :livreid" , nativeQuery=true)
	public Livre_abonner exist(@Param("userid") Long userid, @Param("livreid") Long livreid);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE livre_abonner  SET page_marked= :pageMarked , completion= :completion, finished= :finished where abonne_id= :abonnerid ", nativeQuery=true)
	public void updateMarker(@Param("pageMarked") int pageMarked, @Param("completion") float completion,@Param("finished")boolean finished , @Param("abonnerid") Long abonnerid);
	
	@Query(value="SELECT page_marked, finished FROM livre_abonner u where abonne_id= :abonnerid", nativeQuery=true)
	public Livre_abonner getMarker(@Param("abonnerid") Long abonnerid );
	
	@Modifying
	@Transactional
	@Query(value="UPDATE livre_abonner  SET timer= :timer where abonne_id= :abonnerid ", nativeQuery=true)
	public void updateTimer(@Param("timer") int timer , @Param("abonnerid") Long abonnerid);
	
	
	
	

}

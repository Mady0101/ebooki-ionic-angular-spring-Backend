package com.example.projetpfe.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projetpfe.model.Vues;

@Repository
public interface VuesRepository extends JpaRepository<Vues,Long> {
	
	@Query(value="SELECT COUNT(*) FROM vues WHERE user_id=:userid AND livre_id=:livreid",nativeQuery=true)
	public int isVued(@Param("userid")Long userid,@Param("livreid")Long livreid);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM vues WHERE user_id=:userid AND livre_id=:livreid",nativeQuery=true)
	public void deleteByUserLivre(@Param("userid") Long userid, @Param("livreid") Long livreid);

}

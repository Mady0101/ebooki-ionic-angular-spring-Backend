package com.example.projetpfe.repository;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projetpfe.model.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur,Long> {
	
	@Query(value="SELECT * FROM utilisateur u WHERE u.username = ?1 AND u.password = ?2", nativeQuery=true )
	public Utilisateur login(String username, String password);
	
	@Query(value="SELECT * FROM utilisateur u WHERE username= ?1", nativeQuery = true)
	public Optional<Utilisateur> findbyUsername(String username);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE utilisateur SET email= :email , password=:password ,profile_img=:img, birthday=:birthday WHERE user_id=:userid", nativeQuery = true)
	public void updateUserById (@Param("email")String email, @Param("password")String password , @Param("img")String img , @Param("birthday") Date birthday , @Param("userid")Long userid);
	
	
	@Modifying
	@Transactional
	@Query(value="UPDATE utilisateur SET exp= :exp  WHERE user_id=:userid", nativeQuery = true)
	public void updateUserExpById (@Param("exp")int exp, @Param("userid")Long userid);
	
	Boolean existsByUsername(String username);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE utilisateur SET rank_id= :rank_id  WHERE user_id=:userid", nativeQuery = true)
	public void updateUserRankById (@Param("rank_id")Long rankId, @Param("userid")Long userid);
	
	@Query(value="SELECT password FROM utilisateur u WHERE user_id= ?1", nativeQuery = true)
	public String getUserPassword(@Param("user_id")Long userid);

	Boolean existsByEmail(String email);
}

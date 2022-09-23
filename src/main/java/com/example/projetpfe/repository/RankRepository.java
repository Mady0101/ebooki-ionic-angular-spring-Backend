package com.example.projetpfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetpfe.model.Livre;
import com.example.projetpfe.model.Rank;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {

}

package com.example.projetpfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetpfe.model.Rank;
import com.example.projetpfe.repository.RankRepository;

@Service
public class RankService {
	
	@Autowired
	RankRepository serviceRepository;
	
	public void addRank(Rank rank) {
		serviceRepository.save(rank);
	}

}

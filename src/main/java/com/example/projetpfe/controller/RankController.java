package com.example.projetpfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetpfe.model.Rank;
import com.example.projetpfe.service.RankService;

@CrossOrigin
@RestController
@RequestMapping("/rank")
public class RankController {

	@Autowired
	RankService rankService;
	
	@PostMapping("/add")
	public void addRank(@RequestBody Rank rank) {
		rankService.addRank(rank);
	}
}

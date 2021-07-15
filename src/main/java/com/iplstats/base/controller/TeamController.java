package com.iplstats.base.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.iplstats.base.model.Team;
import com.iplstats.base.repository.MatchRepository;
import com.iplstats.base.repository.TeamRepository;

@CrossOrigin
@RestController
public class TeamController {
	
	private TeamRepository teamRepository;
	private MatchRepository matchRepository;
	
	public TeamController(TeamRepository teamRepository,MatchRepository matchRepository) {
		super();
		this.teamRepository = teamRepository;
		this.matchRepository=matchRepository;
	}

	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		Team team = this.teamRepository.findByTeamName(teamName);
		team.setMatches(matchRepository.findLatestMatchesByTeam(teamName,4));
		return team;
	}

}

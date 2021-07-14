package com.iplstats.base.repository;

import org.springframework.data.repository.CrudRepository;

import com.iplstats.base.model.Team;

public interface TeamRepository extends CrudRepository<Team,Long>{
	
	Team findByTeamName(String teamName);
	

}

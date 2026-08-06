package com.afonsomateus.rachahub_api.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.afonsomateus.rachahub_api.dto.goal.GoalRequestDTO;
import com.afonsomateus.rachahub_api.dto.goal.GoalResponseDTO;
import com.afonsomateus.rachahub_api.entity.Goal;
import com.afonsomateus.rachahub_api.entity.Match;
import com.afonsomateus.rachahub_api.entity.Player;
import com.afonsomateus.rachahub_api.entity.Team;

@Mapper(componentModel = "spring")
public interface GoalMapper {
	GoalResponseDTO toResponse(Goal goal);
	
	@Mapping(source = "playerId", target = "player")
	@Mapping(source = "matchId", target = "match")
	@Mapping(source = "teamId", target = "team")
	Goal toEntity(GoalRequestDTO dto);
	
	default Player mapPlayer(UUID id) {
		if (id == null) return null;
		
		Player player = new Player();
		player.setId(id);
		
		return player;
	}
	
	default Match mapMatch(UUID id) {
		if (id == null) return null;
		
		Match match = new Match();
		match.setId(id);
		
		return match;
	}
	
	default Team mapTeam(UUID id) {
		if (id == null) return null;
		
		Team team = new Team();
		team.setId(id);
		
		return team;
	}
}

package com.afonsomateus.rachahub_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.goal.GoalRequestDTO;
import com.afonsomateus.rachahub_api.dto.goal.GoalResponseDTO;
import com.afonsomateus.rachahub_api.entity.Goal;
import com.afonsomateus.rachahub_api.entity.Match;
import com.afonsomateus.rachahub_api.entity.Player;
import com.afonsomateus.rachahub_api.entity.Team;
import com.afonsomateus.rachahub_api.exceptions.ResourceNotFoundException;
import com.afonsomateus.rachahub_api.mapper.GoalMapper;
import com.afonsomateus.rachahub_api.repository.GoalRepository;
import com.afonsomateus.rachahub_api.repository.MatchRepository;
import com.afonsomateus.rachahub_api.repository.PlayerRepository;
import com.afonsomateus.rachahub_api.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoalService {
	private final GoalRepository goalRepository;
	private final PlayerRepository playerRepository;
	private final MatchRepository matchRepository;
	private final TeamRepository teamRepository;
	private final GoalMapper goalMapper;
	
	public GoalResponseDTO create(GoalRequestDTO dto) {
		Player player = playerRepository.findById(dto.playerId())
			.orElseThrow(() -> new ResourceNotFoundException("Player not found."));
		
		Match match = matchRepository.findById(dto.matchId())
			.orElseThrow(() -> new ResourceNotFoundException("Match not found."));
		
		Team team = teamRepository.findById(dto.teamId())
			.orElseThrow(() -> new ResourceNotFoundException("Team not found."));
		
		Goal goal = goalMapper.toEntity(dto);
		goal.setPlayer(player);
		goal.setMatch(match);
		goal.setTeam(team);
		
		goal = goalRepository.save(goal);
		
		return goalMapper.toResponse(goal);
	}
	
	public List<GoalResponseDTO> findAll() {
		return goalRepository.findAll()
			.stream()
			.map((goal) -> goalMapper.toResponse(goal))
			.toList();
	}
}

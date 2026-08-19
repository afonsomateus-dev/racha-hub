package com.afonsomateus.rachahub_api.service;

import java.util.List;
import java.util.UUID;

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
		
		Goal goal = Goal.builder()
						.player(player)
						.team(team)
						.match(match)
						.build();
		
		return goalMapper.toResponse(goalRepository.save(goal));
	}
	
	public List<GoalResponseDTO> findAll() {
		return goalRepository.findAll()
			.stream()
			.map((goal) -> goalMapper.toResponse(goal))
			.toList();
	}
	
	public GoalResponseDTO findById(UUID id) {
		Goal goal = goalRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Goal not found."));
		
		return goalMapper.toResponse(goal);
	}
	
	public GoalResponseDTO update(UUID id, GoalRequestDTO dto) {
		Goal goal = goalRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Goal not found."));
		
		UUID newPlayerId = dto.playerId() != null ? dto.playerId() : goal.getPlayer().getId();
		UUID newTeamId = dto.teamId() != null ? dto.teamId() : goal.getTeam().getId();
		UUID newMatchId = dto.matchId() != null ? dto.matchId() : goal.getMatch().getId();
		
		if (goal.getPlayer().getId().equals(newPlayerId) 
			&& goal.getTeam().getId().equals(newTeamId) 
			&& goal.getMatch().getId().equals(newMatchId) 
		) {
			return goalMapper.toResponse(goal);
		}
		
		Player player = goal.getPlayer().getId().equals(newPlayerId) 
				? goal.getPlayer()
				: playerRepository.findById(dto.playerId())
					.orElseThrow(() -> new ResourceNotFoundException("Player not found."));
		
		Team team = goal.getTeam().getId().equals(newTeamId)
				? goal.getTeam()
				: teamRepository.findById(dto.teamId())
					.orElseThrow(() -> new ResourceNotFoundException("Team not found."));
		
		Match match = goal.getMatch().getId().equals(newMatchId)
				? goal.getMatch()
				: matchRepository.findById(dto.matchId())
					.orElseThrow(() -> new ResourceNotFoundException("Match not found."));
		
		goal.setPlayer(player);
		goal.setTeam(team);
		goal.setMatch(match);
		
		return goalMapper.toResponse(goalRepository.save(goal));
	}
	
	public void delete(UUID id) {
		goalRepository.deleteById(id);
	}
}

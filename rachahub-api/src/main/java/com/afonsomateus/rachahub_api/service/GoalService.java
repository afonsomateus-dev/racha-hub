package com.afonsomateus.rachahub_api.service;

import java.util.List;
import java.util.UUID;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
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
import com.afonsomateus.rachahub_api.utils.Helpers;

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
	
	public GoalResponseDTO findById(UUID id) {
		Goal goal = goalRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Goal not found."));
		
		return goalMapper.toResponse(goal);
	}
	
	public GoalResponseDTO update(UUID id, GoalRequestDTO dto) {
		Goal goal = goalRepository.getReferenceById(id);
		Player player = null;
		Match match = null;
		Team team = null;
		
		if (dto.playerId() != null) {
			player = playerRepository.getReferenceById(dto.playerId());
			goal.setPlayer(player);
		}
		
		if (dto.matchId() != null) {
			match = matchRepository.getReferenceById(dto.matchId());
			goal.setMatch(match);
		}
		
		if (dto.teamId() != null) {
			team = teamRepository.getReferenceById(dto.teamId());
			goal.setTeam(team);
		}
		
		goalRepository.save(goal);
		
		return goalMapper.toResponse(goal);
	}
	
	public void delete(UUID id) {
		goalRepository.deleteById(id);
	}
}

package com.afonsomateus.rachahub_api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.teamMatch.TeamMatchRequestDTO;
import com.afonsomateus.rachahub_api.dto.teamMatch.TeamMatchResponseDTO;
import com.afonsomateus.rachahub_api.entity.Match;
import com.afonsomateus.rachahub_api.entity.Team;
import com.afonsomateus.rachahub_api.entity.TeamMatch;
import com.afonsomateus.rachahub_api.entity.TeamMatchId;
import com.afonsomateus.rachahub_api.exceptions.ResourceNotFoundException;
import com.afonsomateus.rachahub_api.mapper.TeamMatchMapper;
import com.afonsomateus.rachahub_api.repository.MatchRepository;
import com.afonsomateus.rachahub_api.repository.TeamMatchRepository;
import com.afonsomateus.rachahub_api.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamMatchService {
	private final TeamMatchRepository teamMatchRepository;
	private final TeamRepository teamRepository;
	private final MatchRepository matchRepository;
	private final TeamMatchMapper teamMatchMapper;
	
	public TeamMatchResponseDTO create(TeamMatchRequestDTO dto) {
		Team team = teamRepository.findById(dto.teamId())
				.orElseThrow(() -> new ResourceNotFoundException("Team not found."));
		
		Match match = matchRepository.findById(dto.matchId())
				.orElseThrow(() -> new ResourceNotFoundException("Match not found."));
		
		TeamMatch teamMatch = new TeamMatch();
		teamMatch.setMatch(match);
		teamMatch.setTeam(team);
		teamMatch.setGoals(dto.goals());
		
		return teamMatchMapper.toResponse(teamMatchRepository.save(teamMatch));
	}
	
	public List<TeamMatchResponseDTO> findAll() {
		return teamMatchRepository.findAll()
			.stream()
			.map((tm) -> teamMatchMapper.toResponse(tm))
			.toList();
	}
	
	public TeamMatchResponseDTO findById(UUID teamId, UUID matchId) {
		TeamMatchId id = new TeamMatchId(teamId, matchId);
		TeamMatch teamMatch = teamMatchRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("The team did not play this match."));
		
		return teamMatchMapper.toResponse(teamMatch);
	}
}

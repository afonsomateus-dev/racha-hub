package com.afonsomateus.rachahub_api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.assist.AssistRequestDTO;
import com.afonsomateus.rachahub_api.dto.assist.AssistResponseDTO;
import com.afonsomateus.rachahub_api.entity.Assist;
import com.afonsomateus.rachahub_api.entity.Match;
import com.afonsomateus.rachahub_api.entity.Player;
import com.afonsomateus.rachahub_api.entity.Team;
import com.afonsomateus.rachahub_api.exceptions.ResourceNotFoundException;
import com.afonsomateus.rachahub_api.mapper.AssistMapper;
import com.afonsomateus.rachahub_api.repository.AssistRepository;
import com.afonsomateus.rachahub_api.repository.MatchRepository;
import com.afonsomateus.rachahub_api.repository.PlayerRepository;
import com.afonsomateus.rachahub_api.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssistService {
	private final AssistRepository assistRepository;
	private final PlayerRepository playerRepository;
	private final TeamRepository teamRepository;
	private final MatchRepository matchRepository;
	private final AssistMapper assistMapper;
	
	public AssistResponseDTO create(AssistRequestDTO dto) {
		Player player = playerRepository.findById(dto.playerId())
			.orElseThrow(() -> new ResourceNotFoundException("Player not found."));
		
		Match match = matchRepository.findById(dto.matchId())
			.orElseThrow(() -> new ResourceNotFoundException("Match not found."));
		
		Team team = teamRepository.findById(dto.teamId())
			.orElseThrow(() -> new ResourceNotFoundException("Team not found."));	
		
		Assist assist = Assist.builder()
							.player(player)
							.match(match)
							.team(team)
							.build();
		
		return assistMapper.toResponse(assistRepository.save(assist));
	}
	
	public List<AssistResponseDTO> findAll() {
		return assistRepository.findAll()
			.stream()
			.map((assist) -> assistMapper.toResponse(assist))
			.toList();
	}
	
	public AssistResponseDTO findById(UUID id) {
		Assist assist = assistRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Assist not found."));
		
		return assistMapper.toResponse(assist);
	}
	
	public AssistResponseDTO update(UUID id, AssistRequestDTO dto) {
		Assist assist = assistRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Assist not found."));
		
		UUID newPlayerId = dto.playerId() != null ? dto.playerId() : assist.getPlayer().getId();
		UUID newTeamId = dto.teamId() != null ? dto.teamId() : assist.getTeam().getId();
		UUID newMatchId = dto.matchId() != null ? dto.matchId() : assist.getMatch().getId();
		
		if (assist.getPlayer().getId().equals(newPlayerId) 
			&& assist.getTeam().getId().equals(newTeamId) 
			&& assist.getMatch().getId().equals(newMatchId) 
		) {
			return assistMapper.toResponse(assist);
		}
		
		Player player = assist.getPlayer().getId().equals(newPlayerId) 
				? assist.getPlayer()
				: playerRepository.findById(dto.playerId())
					.orElseThrow(() -> new ResourceNotFoundException("Player not found."));
		
		Team team = assist.getTeam().getId().equals(newTeamId)
				? assist.getTeam()
				: teamRepository.findById(dto.teamId())
					.orElseThrow(() -> new ResourceNotFoundException("Team not found."));
		
		Match match = assist.getMatch().getId().equals(newMatchId)
				? assist.getMatch()
				: matchRepository.findById(dto.matchId())
					.orElseThrow(() -> new ResourceNotFoundException("Match not found."));
		
		assist.setPlayer(player);
		assist.setTeam(team);
		assist.setMatch(match);
		
		return assistMapper.toResponse(assistRepository.save(assist));
	}
	
	public void delete(UUID id) {
		assistRepository.deleteById(id);
	}
}

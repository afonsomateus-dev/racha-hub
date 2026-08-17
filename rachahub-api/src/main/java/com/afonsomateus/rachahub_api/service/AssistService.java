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
		
		Assist assist = new Assist();
		assist.setPlayer(player);
		assist.setMatch(match);
		assist.setTeam(team);
		
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
		
		if (dto.playerId() != null) {
			Player player = playerRepository.findById(dto.playerId())
				.orElseThrow(() -> new ResourceNotFoundException("Player not found."));
			assist.setPlayer(player);
		}
		
		if (dto.teamId() != null) {
			Team team = teamRepository.findById(dto.teamId())
					.orElseThrow(() -> new ResourceNotFoundException("Team not found."));
			assist.setTeam(team);
		}
		
		if (dto.matchId() != null) {
			Match match = matchRepository.findById(dto.matchId())
				.orElseThrow(() -> new ResourceNotFoundException("Match not found."));
			assist.setMatch(match);
		}
		
		assistRepository.save(assist);
		
		return assistMapper.toResponse(assist);
	}
	
	public void delete(UUID id) {
		assistRepository.deleteById(id);
	}
}

package com.afonsomateus.rachahub_api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.participation.ParticipationRequestDTO;
import com.afonsomateus.rachahub_api.dto.participation.ParticipationResponseDTO;
import com.afonsomateus.rachahub_api.entity.Match;
import com.afonsomateus.rachahub_api.entity.Participation;
import com.afonsomateus.rachahub_api.entity.Team;
import com.afonsomateus.rachahub_api.exceptions.ResourceNotFoundException;
import com.afonsomateus.rachahub_api.mapper.ParticipationMapper;
import com.afonsomateus.rachahub_api.repository.MatchRepository;
import com.afonsomateus.rachahub_api.repository.ParticipationRepository;
import com.afonsomateus.rachahub_api.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParticipationService {
	private final ParticipationRepository participationRepository;
	private final MatchRepository matchRepository;
	private final TeamRepository teamRepository;
	private final ParticipationMapper participationMapper;
	
	public ParticipationResponseDTO create(ParticipationRequestDTO dto) {
		Match match = matchRepository.findById(dto.matchId())
			.orElseThrow(() -> new ResourceNotFoundException("Match not found."));
		
		Team team = teamRepository.findById(dto.teamId())
			.orElseThrow(() -> new ResourceNotFoundException("Team not found."));
		
		Participation participation = new Participation();
		participation.setMatch(match);
		participation.setTeam(team);
		
		participation = participationRepository.save(participation);
		
		return participationMapper.toResponse(participation);
	}
	
	public List<ParticipationResponseDTO> findAll() {
		return participationRepository.findAll()
			.stream()
			.map((participation) -> participationMapper.toResponse(participation))
			.toList();
	}
	
	public ParticipationResponseDTO findById(UUID id) {
		Participation participation = participationRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Participation not found."));
		
		return participationMapper.toResponse(participation);
	}
}

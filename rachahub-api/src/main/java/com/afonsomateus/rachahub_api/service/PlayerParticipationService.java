package com.afonsomateus.rachahub_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.playerParticipation.PlayerParticipationRequestDTO;
import com.afonsomateus.rachahub_api.dto.playerParticipation.PlayerParticipationResponseDTO;
import com.afonsomateus.rachahub_api.entity.Participation;
import com.afonsomateus.rachahub_api.entity.Player;
import com.afonsomateus.rachahub_api.entity.PlayerParticipation;
import com.afonsomateus.rachahub_api.exceptions.ResourceNotFoundException;
import com.afonsomateus.rachahub_api.mapper.PlayerParticipationMapper;
import com.afonsomateus.rachahub_api.repository.ParticipationRepository;
import com.afonsomateus.rachahub_api.repository.PlayerParticipationRepository;
import com.afonsomateus.rachahub_api.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerParticipationService {
	private final PlayerParticipationRepository playerParticipationRepository;
	private final PlayerParticipationMapper playerParticipationMapper;
	private final PlayerRepository playerRepository;
	private final ParticipationRepository participationRepository;
	
	public PlayerParticipationResponseDTO create(PlayerParticipationRequestDTO dto) {
		Player player = playerRepository
			.findById(dto.playerId())
			.orElseThrow(() -> new ResourceNotFoundException("Player not found."));
		
		Participation participation = participationRepository
			.findById(dto.participationId())
			.orElseThrow(() -> new ResourceNotFoundException("Participation not found."));
		
		PlayerParticipation playerParticipation = new PlayerParticipation();
		playerParticipation.setPlayer(player);
		playerParticipation.setParticipation(participation);
		
		playerParticipation = playerParticipationRepository.save(playerParticipation);
		
		return playerParticipationMapper.toResponse(playerParticipation);
	}
	
	public List<PlayerParticipationResponseDTO> findAll() {
		return playerParticipationRepository.findAll()
			.stream()
			.map((pp) -> playerParticipationMapper.toResponse(pp))
			.toList();
	}
}

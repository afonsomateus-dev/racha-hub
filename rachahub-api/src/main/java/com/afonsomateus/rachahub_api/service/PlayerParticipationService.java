package com.afonsomateus.rachahub_api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.playerParticipation.PlayerParticipationRequestDTO;
import com.afonsomateus.rachahub_api.dto.playerParticipation.PlayerParticipationResponseDTO;
import com.afonsomateus.rachahub_api.entity.Participation;
import com.afonsomateus.rachahub_api.entity.Player;
import com.afonsomateus.rachahub_api.entity.PlayerParticipation;
import com.afonsomateus.rachahub_api.entity.PlayerParticipationId;
import com.afonsomateus.rachahub_api.exceptions.ResourceAlreadyExistsException;
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
	
	public PlayerParticipationResponseDTO findById(UUID playerId, UUID participationId) {
		PlayerParticipationId id = new PlayerParticipationId(playerId, participationId);
		PlayerParticipation playerParticipation = playerParticipationRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Player participation not found."));
		
		return playerParticipationMapper.toResponse(playerParticipation);
	}
	
	public PlayerParticipationResponseDTO update(UUID playerId, UUID participationId, PlayerParticipationRequestDTO dto) {
		PlayerParticipationId oldId = new PlayerParticipationId(playerId, participationId);
		PlayerParticipation playerParticipation = playerParticipationRepository.findById(oldId)
			.orElseThrow(() -> new ResourceNotFoundException("Player participation not found."));
		
		UUID newPlayerId = dto.playerId() != null ? dto.playerId() : playerId;
		UUID newParticipationId = dto.participationId() != null ? dto.participationId() : participationId;
		
		if (playerId.equals(newPlayerId) && playerId.equals(newParticipationId)) {
			return playerParticipationMapper.toResponse(playerParticipation);
		}
		
		Player player = playerRepository
			.findById(newPlayerId)
			.orElseThrow(() -> new ResourceNotFoundException("Player not found."));
		
		Participation participation = participationRepository
			.findById(newParticipationId)
			.orElseThrow(() -> new ResourceNotFoundException("Participation not found."));
		
		PlayerParticipationId newId = new PlayerParticipationId(newPlayerId, newParticipationId);
		
		if (playerParticipationRepository.existsById(newId)) {
			throw new ResourceAlreadyExistsException("Player participation already exists");
		}
		
		playerParticipationRepository.deleteById(oldId);
		
		PlayerParticipation playerParticipationToSave = new PlayerParticipation();
		playerParticipationToSave.setId(newId);
		playerParticipationToSave.setPlayer(player);
		playerParticipationToSave.setParticipation(participation);
		
		return playerParticipationMapper.toResponse(playerParticipationToSave);
	}
	
	public void delete(UUID playerId, UUID participationId) {
		PlayerParticipationId id = new PlayerParticipationId(playerId, participationId);
		playerParticipationRepository.deleteById(id);
	}
}

package com.afonsomateus.rachahub_api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afonsomateus.rachahub_api.dto.playerParticipation.PlayerParticipationRequestDTO;
import com.afonsomateus.rachahub_api.dto.playerParticipation.PlayerParticipationResponseDTO;
import com.afonsomateus.rachahub_api.service.PlayerParticipationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/player-participations")
@RequiredArgsConstructor
public class PlayerParticipationController {
	private final PlayerParticipationService playerParticipationService;
	
	@PostMapping
	public ResponseEntity<PlayerParticipationResponseDTO> create(@Valid @RequestBody PlayerParticipationRequestDTO dto) {
		PlayerParticipationResponseDTO response = playerParticipationService.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<PlayerParticipationResponseDTO>> findAll() {
		List<PlayerParticipationResponseDTO> response = playerParticipationService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/players/{playerId}/participations/{participationId}")
	public ResponseEntity<PlayerParticipationResponseDTO> findById(@PathVariable UUID playerId, @PathVariable UUID participationId) {
		PlayerParticipationResponseDTO response = playerParticipationService.findById(playerId, participationId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PatchMapping("/players/{playerId}/participations/{participationId}")
	public ResponseEntity<PlayerParticipationResponseDTO> update(
		@PathVariable UUID playerId, 
		@PathVariable UUID participationId,
		@Valid @RequestBody PlayerParticipationRequestDTO dto
	) {
		PlayerParticipationResponseDTO response = playerParticipationService.update(playerId, participationId, dto);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/players/{playerId}/participations/{participationId}")
	public ResponseEntity<Void> delete(@PathVariable UUID playerId, @PathVariable UUID participationId) {
		playerParticipationService.delete(playerId, participationId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}

package com.afonsomateus.rachahub_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}

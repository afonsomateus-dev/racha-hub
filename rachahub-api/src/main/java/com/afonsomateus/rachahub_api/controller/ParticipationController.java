package com.afonsomateus.rachahub_api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afonsomateus.rachahub_api.dto.participation.ParticipationRequestDTO;
import com.afonsomateus.rachahub_api.dto.participation.ParticipationResponseDTO;
import com.afonsomateus.rachahub_api.service.ParticipationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/participations")
@RequiredArgsConstructor
public class ParticipationController {
	private final ParticipationService participationService;
	
	@PostMapping
	public ResponseEntity<ParticipationResponseDTO> create(@Valid @RequestBody ParticipationRequestDTO dto) {
		ParticipationResponseDTO response = participationService.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<ParticipationResponseDTO>> findAll() {
		List<ParticipationResponseDTO> response = participationService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
 	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ParticipationResponseDTO> findById(@PathVariable UUID id) {
		ParticipationResponseDTO response = participationService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}

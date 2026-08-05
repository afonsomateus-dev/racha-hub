package com.afonsomateus.rachahub_api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afonsomateus.rachahub_api.dto.match.MatchRequestDTO;
import com.afonsomateus.rachahub_api.dto.match.MatchResponseDTO;
import com.afonsomateus.rachahub_api.service.MatchService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/matches")
public class MatchController {
	private final MatchService matchService;
	
	public MatchController(MatchService service) {
		this.matchService = service;
	}

	@PostMapping
	public ResponseEntity<MatchResponseDTO> create(@Valid @RequestBody MatchRequestDTO dto) {
		MatchResponseDTO response = matchService.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<MatchResponseDTO>> findAll() {
		List<MatchResponseDTO> response = matchService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MatchResponseDTO> findById(@PathVariable UUID id) {
		MatchResponseDTO response = matchService.findById(id); 
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<MatchResponseDTO> update(@PathVariable UUID id, @Valid @RequestBody MatchRequestDTO dto) {
		MatchResponseDTO response = matchService.update(id, dto); 
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}

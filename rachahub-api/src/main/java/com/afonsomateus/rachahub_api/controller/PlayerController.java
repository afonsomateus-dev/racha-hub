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

import com.afonsomateus.rachahub_api.dto.player.PlayerRequestDTO;
import com.afonsomateus.rachahub_api.dto.player.PlayerResponseDTO;
import com.afonsomateus.rachahub_api.service.PlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/players")
public class PlayerController {
	private PlayerService playerService;
	
	public PlayerController(PlayerService service) {
		this.playerService = service;
	}
	
	@PostMapping
	public PlayerResponseDTO create(@Valid @RequestBody PlayerRequestDTO dto) {
		return playerService.create(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<PlayerResponseDTO>> list() {
		List<PlayerResponseDTO> players = playerService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(players);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PlayerResponseDTO> getById(@PathVariable UUID id) {
		PlayerResponseDTO player = playerService.getById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(player);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<PlayerResponseDTO> update(@PathVariable UUID id, @Valid @RequestBody PlayerRequestDTO dto) {
		PlayerResponseDTO player = playerService.update(id, dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(player);
	}
}

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

import com.afonsomateus.rachahub_api.dto.team.TeamRequestDTO;
import com.afonsomateus.rachahub_api.dto.team.TeamResponseDTO;
import com.afonsomateus.rachahub_api.service.TeamService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teams")
public class TeamController {
	private final TeamService teamService;
	
	public TeamController(TeamService service) {
		this.teamService = service;
	}
	
	@PostMapping
	public ResponseEntity<TeamResponseDTO> create(@Valid @RequestBody TeamRequestDTO dto) {
		TeamResponseDTO response = teamService.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<TeamResponseDTO>> list() {
		List<TeamResponseDTO> teams = teamService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(teams);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TeamResponseDTO> getById(@PathVariable UUID id) {
		TeamResponseDTO team = teamService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(team);
	}
}

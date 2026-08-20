package com.afonsomateus.rachahub_api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afonsomateus.rachahub_api.dto.general.OnCreate;
import com.afonsomateus.rachahub_api.dto.team.TeamRequestDTO;
import com.afonsomateus.rachahub_api.dto.team.TeamResponseDTO;
import com.afonsomateus.rachahub_api.service.TeamService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {
	private final TeamService teamService;
	
	@PostMapping
	public ResponseEntity<TeamResponseDTO> create(@Validated(OnCreate.class) @RequestBody TeamRequestDTO dto) {
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
		TeamResponseDTO team = teamService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(team);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<TeamResponseDTO> update(@PathVariable UUID id, @RequestBody TeamRequestDTO dto) {
		TeamResponseDTO team = teamService.update(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(team);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		teamService.delete(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}

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

import com.afonsomateus.rachahub_api.dto.teamMatch.TeamMatchRequestDTO;
import com.afonsomateus.rachahub_api.dto.teamMatch.TeamMatchResponseDTO;
import com.afonsomateus.rachahub_api.service.TeamMatchService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/team-matches")
@RequiredArgsConstructor
public class TeamMatchController {
	private final TeamMatchService teamMatchService;
	
	@PostMapping
	public ResponseEntity<TeamMatchResponseDTO> create(@Valid @RequestBody TeamMatchRequestDTO dto) {
		TeamMatchResponseDTO response = teamMatchService.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<TeamMatchResponseDTO>> findAll() {
		List<TeamMatchResponseDTO> response = teamMatchService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/teams/{teamId}/matches/{matchId}")
	public ResponseEntity<TeamMatchResponseDTO> findById(@PathVariable UUID teamId, @PathVariable UUID matchId) {
		TeamMatchResponseDTO response = teamMatchService.findById(teamId, matchId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PatchMapping("/teams/{teamId}/matches/{matchId}")
	public ResponseEntity<TeamMatchResponseDTO> update(
		@PathVariable UUID teamId, 
		@PathVariable UUID matchId, 
		@RequestBody TeamMatchRequestDTO dto
	) {
		TeamMatchResponseDTO response = teamMatchService.update(teamId, matchId, dto);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/teams/{teamId}/matches/{matchId}")
	public ResponseEntity<Void> delete(@PathVariable UUID teamId, @PathVariable UUID matchId) {
		teamMatchService.delete(teamId, matchId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}

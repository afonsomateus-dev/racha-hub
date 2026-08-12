package com.afonsomateus.rachahub_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
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
}

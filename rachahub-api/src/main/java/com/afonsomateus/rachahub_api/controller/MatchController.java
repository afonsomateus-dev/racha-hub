package com.afonsomateus.rachahub_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		System.out.println(dto);
		MatchResponseDTO response = matchService.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}

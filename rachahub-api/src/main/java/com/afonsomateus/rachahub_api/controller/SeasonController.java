package com.afonsomateus.rachahub_api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.afonsomateus.rachahub_api.dto.season.SeasonRequestDTO;
import com.afonsomateus.rachahub_api.dto.season.SeasonResponseDTO;
import com.afonsomateus.rachahub_api.service.SeasonService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/seasons")
public class SeasonController {
	private final SeasonService seasonService;

	public SeasonController(SeasonService seasonService) {
		this.seasonService = seasonService;
	}
	
	@PostMapping
	public ResponseEntity<SeasonResponseDTO> create(@Valid @RequestBody SeasonRequestDTO dto) {
		SeasonResponseDTO response = seasonService.create(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<SeasonResponseDTO>> findAll() {
		List<SeasonResponseDTO> response = seasonService.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SeasonResponseDTO> findById(@PathVariable UUID id) {
		SeasonResponseDTO response = seasonService.findById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<SeasonResponseDTO> update(@PathVariable UUID id, @Valid @RequestBody SeasonRequestDTO dto) {
		SeasonResponseDTO response = seasonService.update(id, dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		seasonService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}

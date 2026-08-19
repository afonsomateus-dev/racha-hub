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

import com.afonsomateus.rachahub_api.dto.assist.AssistRequestDTO;
import com.afonsomateus.rachahub_api.dto.assist.AssistResponseDTO;
import com.afonsomateus.rachahub_api.dto.general.OnCreate;
import com.afonsomateus.rachahub_api.service.AssistService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/assists")
@RequiredArgsConstructor
public class AssistController {
	private final AssistService assistService;
	
	@PostMapping
	public ResponseEntity<AssistResponseDTO> create(@Validated(OnCreate.class) @RequestBody AssistRequestDTO dto) {
		AssistResponseDTO response = assistService.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<AssistResponseDTO>> findAll() {
		List<AssistResponseDTO> response = assistService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AssistResponseDTO> findById(@PathVariable UUID id) {
		AssistResponseDTO response = assistService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<AssistResponseDTO> update(
		@PathVariable UUID id, 
		@RequestBody AssistRequestDTO dto
	) {
		AssistResponseDTO response = assistService.update(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable UUID id) {
		assistService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}

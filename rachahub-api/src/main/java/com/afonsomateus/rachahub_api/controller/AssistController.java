package com.afonsomateus.rachahub_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afonsomateus.rachahub_api.dto.assist.AssistRequestDTO;
import com.afonsomateus.rachahub_api.dto.assist.AssistResponseDTO;
import com.afonsomateus.rachahub_api.service.AssistService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/assists")
@RequiredArgsConstructor
public class AssistController {
	private final AssistService assistService;
	
	@PostMapping
	public ResponseEntity<AssistResponseDTO> create(@Valid @RequestBody AssistRequestDTO dto) {
		AssistResponseDTO response = assistService.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<AssistResponseDTO>> findAll() {
		List<AssistResponseDTO> response = assistService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}

package com.afonsomateus.rachahub_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afonsomateus.rachahub_api.dto.goal.GoalRequestDTO;
import com.afonsomateus.rachahub_api.dto.goal.GoalResponseDTO;
import com.afonsomateus.rachahub_api.service.GoalService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/goals")
@RequiredArgsConstructor
public class GoalController {
	private final GoalService goalService;
	
	@PostMapping
	public ResponseEntity<GoalResponseDTO> create(@Valid @RequestBody GoalRequestDTO dto) {
		GoalResponseDTO response = goalService.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<GoalResponseDTO>> findAll() {
		List<GoalResponseDTO> response = goalService.findAll();
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}

package com.afonsomateus.rachahub_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
	public List<PlayerResponseDTO> list() {
		try {
			return playerService.findAll();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}

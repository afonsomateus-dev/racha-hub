package com.afonsomateus.rachahub_api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.player.PlayerRequestDTO;
import com.afonsomateus.rachahub_api.dto.player.PlayerResponseDTO;
import com.afonsomateus.rachahub_api.entity.Player;
import com.afonsomateus.rachahub_api.exceptions.ResourceNotFoundException;
import com.afonsomateus.rachahub_api.mapper.PlayerMapper;
import com.afonsomateus.rachahub_api.repository.PlayerRepository;
import com.afonsomateus.rachahub_api.utils.Helpers;

@Service
public class PlayerService {
	private PlayerRepository playerRepository;
	private PlayerMapper playerMapper;
	
	public PlayerService(PlayerRepository repository, PlayerMapper mapper) {
		this.playerRepository = repository;
		this.playerMapper = mapper;
	}
	
	public PlayerResponseDTO create(PlayerRequestDTO dto) {
		Player player = playerMapper.toEntity(dto);
		player = playerRepository.save(player);
		
		return playerMapper.toResponse(player);
	}
	
	public List<PlayerResponseDTO> findAll() {
		return playerRepository.findAll()
			.stream()
			.map(player -> playerMapper.toResponse(player))
			.toList();	
	}
	
	public PlayerResponseDTO getById(UUID id) {
		Player player = playerRepository
			.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Player not found."));

		return playerMapper.toResponse(player);
	}
	
	public PlayerResponseDTO update(UUID id, PlayerRequestDTO dto) {
		Player player = playerRepository
			.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Player not found."));
		
		Player playerReceived = playerMapper.toEntity(dto);
		
		BeanUtils.copyProperties(playerReceived, player, Helpers.getNullPropertyNames(playerMapper.toEntity(dto)));
		
		playerRepository.save(player);
		
		return playerMapper.toResponse(player);
	}
	
	public void delete(UUID id) {
		playerRepository.deleteById(id);
	}
}

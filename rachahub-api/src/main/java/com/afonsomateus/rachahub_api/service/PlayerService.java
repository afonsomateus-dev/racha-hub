package com.afonsomateus.rachahub_api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.player.PlayerRequestDTO;
import com.afonsomateus.rachahub_api.dto.player.PlayerResponseDTO;
import com.afonsomateus.rachahub_api.entity.Player;
import com.afonsomateus.rachahub_api.mapper.PlayerMapper;
import com.afonsomateus.rachahub_api.repository.PlayerRepository;

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
		try {
			return playerRepository.findAll()
				.stream()
				.map(player -> playerMapper.toResponse(player))
				.toList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}

package com.afonsomateus.rachahub_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.team.TeamRequestDTO;
import com.afonsomateus.rachahub_api.dto.team.TeamResponseDTO;
import com.afonsomateus.rachahub_api.entity.Team;
import com.afonsomateus.rachahub_api.mapper.TeamMapper;
import com.afonsomateus.rachahub_api.repository.TeamRepository;

@Service
public class TeamService {
	private final TeamRepository teamRepository;
	private final TeamMapper teamMapper;
	
	public TeamService(TeamRepository repository, TeamMapper mapper) {
		this.teamRepository = repository;
		this.teamMapper = mapper;
	}
	
	public TeamResponseDTO create(TeamRequestDTO dto) {
		Team team = teamMapper.toEntity(dto);
		team = teamRepository.save(team);
		
		return teamMapper.toResponse(team);
	}
	
	public List<TeamResponseDTO> findAll() {
		return teamRepository.findAll()
			.stream()
			.map((team) -> teamMapper.toResponse(team))
			.toList();
	}
}
	
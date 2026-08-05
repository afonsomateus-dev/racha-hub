package com.afonsomateus.rachahub_api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.season.SeasonRequestDTO;
import com.afonsomateus.rachahub_api.dto.season.SeasonResponseDTO;
import com.afonsomateus.rachahub_api.entity.Season;
import com.afonsomateus.rachahub_api.exceptions.ResourceNotFoundException;
import com.afonsomateus.rachahub_api.mapper.SeasonMapper;
import com.afonsomateus.rachahub_api.repository.SeasonRepository;
import com.afonsomateus.rachahub_api.utils.Helpers;

@Service
public class SeasonService {
	private final SeasonRepository seasonRepository;
	private final SeasonMapper seasonMapper;
	
	public SeasonService(SeasonRepository repository, SeasonMapper mapper) {
		this.seasonRepository = repository;
		this.seasonMapper = mapper;
	}
	
	public SeasonResponseDTO create(SeasonRequestDTO dto) {
		Season season = seasonMapper.toEntity(dto);
		season = seasonRepository.save(season);
		
		return seasonMapper.toResponse(season);
	}
	
	public List<SeasonResponseDTO> findAll() {
		return seasonRepository
			.findAll()
			.stream()
			.map((season) -> seasonMapper.toResponse(season))
			.toList();
	}
	
	public SeasonResponseDTO findById(UUID id) {
		Season season = seasonRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Season not found."));
		
		return seasonMapper.toResponse(season);
	}
	
	public SeasonResponseDTO update(UUID id, SeasonRequestDTO dto) {
		Season season = seasonRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Season not found."));
		
		Season seasonReceived = seasonMapper.toEntity(dto);
		
		BeanUtils.copyProperties(seasonReceived, season, Helpers.getNullPropertyNames(seasonReceived));
		
		seasonRepository.save(season);
		
		return seasonMapper.toResponse(season);
	}
}

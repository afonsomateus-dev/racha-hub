package com.afonsomateus.rachahub_api.service;

import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.season.SeasonRequestDTO;
import com.afonsomateus.rachahub_api.dto.season.SeasonResponseDTO;
import com.afonsomateus.rachahub_api.entity.Season;
import com.afonsomateus.rachahub_api.mapper.SeasonMapper;
import com.afonsomateus.rachahub_api.repository.SeasonRepository;

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
}

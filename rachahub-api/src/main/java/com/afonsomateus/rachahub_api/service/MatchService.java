package com.afonsomateus.rachahub_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.match.MatchRequestDTO;
import com.afonsomateus.rachahub_api.dto.match.MatchResponseDTO;
import com.afonsomateus.rachahub_api.entity.Match;
import com.afonsomateus.rachahub_api.entity.Season;
import com.afonsomateus.rachahub_api.exceptions.ResourceNotFoundException;
import com.afonsomateus.rachahub_api.mapper.MatchMapper;
import com.afonsomateus.rachahub_api.repository.MatchRepository;
import com.afonsomateus.rachahub_api.repository.SeasonRepository;

@Service
public class MatchService {
	private final MatchRepository matchRepository;
	private final SeasonRepository seasonRepository;
	private final MatchMapper matchMapper;
	
	public MatchService(MatchRepository matchRepository, SeasonRepository seasonRepository, MatchMapper mapper) {
		this.matchRepository = matchRepository;
		this.matchMapper = mapper;
		this.seasonRepository = seasonRepository;
	}
	
	public MatchResponseDTO create(MatchRequestDTO dto) {
		Season season = seasonRepository.findById(dto.seasonId())
			.orElseThrow(() -> new ResourceNotFoundException("Season not found."));
		
		Match match = matchMapper.toEntity(dto);
		match.setSeason(season);
		
		match = matchRepository.save(match);
		
		return matchMapper.toResponse(match);
	}
	
	public List<MatchResponseDTO> findAll() {
		return matchRepository.findAll()
			.stream()
			.map((match) -> matchMapper.toResponse(match))
			.toList();
	}
}

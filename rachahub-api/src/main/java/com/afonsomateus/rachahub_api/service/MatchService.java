package com.afonsomateus.rachahub_api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.afonsomateus.rachahub_api.dto.match.MatchRequestDTO;
import com.afonsomateus.rachahub_api.dto.match.MatchResponseDTO;
import com.afonsomateus.rachahub_api.entity.Match;
import com.afonsomateus.rachahub_api.entity.Season;
import com.afonsomateus.rachahub_api.exceptions.ResourceNotFoundException;
import com.afonsomateus.rachahub_api.mapper.MatchMapper;
import com.afonsomateus.rachahub_api.repository.MatchRepository;
import com.afonsomateus.rachahub_api.repository.SeasonRepository;
import com.afonsomateus.rachahub_api.utils.Helpers;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatchService {
	private final MatchRepository matchRepository;
	private final SeasonRepository seasonRepository;
	private final MatchMapper matchMapper;
	
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
	
	public MatchResponseDTO findById(UUID id) {
		Match match = matchRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Match not found."));
		
		return matchMapper.toResponse(match);
	}
	
	public MatchResponseDTO update(UUID id, MatchRequestDTO dto) {
		if (dto.seasonId() != null) {
			seasonRepository.findById(dto.seasonId())
				.orElseThrow(() -> new ResourceNotFoundException("Season not found."));
		}
		
		Match match = matchRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Season not found."));
		
		Match matchReceived = matchMapper.toEntity(dto);
		
		BeanUtils.copyProperties(matchReceived, match, Helpers.getNullPropertyNames(matchReceived));
		
		match = matchRepository.save(match);
		
		return matchMapper.toResponse(match);
	}
	
	public void delete(UUID id) {
		matchRepository.deleteById(id);
	}
}

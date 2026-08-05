package com.afonsomateus.rachahub_api.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.afonsomateus.rachahub_api.dto.match.MatchRequestDTO;
import com.afonsomateus.rachahub_api.dto.match.MatchResponseDTO;
import com.afonsomateus.rachahub_api.entity.Match;
import com.afonsomateus.rachahub_api.entity.Season;

@Mapper(componentModel = "spring")
public interface MatchMapper {
	MatchResponseDTO toResponse(Match match);
	
	@Mapping(source = "seasonId", target = "season")
	Match toEntity(MatchRequestDTO matchDTO);
	
	default Season map(UUID id) {
		if (id == null) return null;
		
		Season season = new Season();
		season.setId(id);
		return season;
	}
}

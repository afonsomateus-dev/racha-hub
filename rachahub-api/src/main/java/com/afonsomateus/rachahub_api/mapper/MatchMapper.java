package com.afonsomateus.rachahub_api.mapper;

import org.mapstruct.Mapper;

import com.afonsomateus.rachahub_api.dto.match.MatchRequestDTO;
import com.afonsomateus.rachahub_api.dto.match.MatchResponseDTO;
import com.afonsomateus.rachahub_api.entity.Match;

@Mapper(componentModel = "spring")
public interface MatchMapper {
	MatchResponseDTO toResponse(Match match);
	Match toEntity(MatchRequestDTO matchDTO);
}

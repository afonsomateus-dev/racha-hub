package com.afonsomateus.rachahub_api.mapper;

import org.mapstruct.Mapper;

import com.afonsomateus.rachahub_api.dto.teamMatch.TeamMatchRequestDTO;
import com.afonsomateus.rachahub_api.dto.teamMatch.TeamMatchResponseDTO;
import com.afonsomateus.rachahub_api.entity.TeamMatch;

@Mapper(componentModel = "spring")
public interface TeamMatchMapper {
	TeamMatchResponseDTO toResponse(TeamMatch teamMatch);
	TeamMatch toEntity(TeamMatchRequestDTO teamMatchDTO);
}

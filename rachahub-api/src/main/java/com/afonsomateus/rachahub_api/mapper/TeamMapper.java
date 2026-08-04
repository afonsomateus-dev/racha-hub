package com.afonsomateus.rachahub_api.mapper;

import org.mapstruct.Mapper;

import com.afonsomateus.rachahub_api.dto.team.TeamRequestDTO;
import com.afonsomateus.rachahub_api.dto.team.TeamResponseDTO;
import com.afonsomateus.rachahub_api.entity.Team;

@Mapper(componentModel = "spring")
public interface TeamMapper {
	TeamResponseDTO toResponse(Team team);
	Team toEntity(TeamRequestDTO teamDTO);
}

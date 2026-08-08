package com.afonsomateus.rachahub_api.mapper;

import org.mapstruct.Mapper;

import com.afonsomateus.rachahub_api.dto.participation.ParticipationRequestDTO;
import com.afonsomateus.rachahub_api.dto.participation.ParticipationResponseDTO;
import com.afonsomateus.rachahub_api.entity.Participation;

@Mapper(componentModel = "spring")
public interface ParticipationMapper {
	ParticipationResponseDTO toResponse(Participation participation);
	Participation toEntity(ParticipationRequestDTO participationDTO);
}

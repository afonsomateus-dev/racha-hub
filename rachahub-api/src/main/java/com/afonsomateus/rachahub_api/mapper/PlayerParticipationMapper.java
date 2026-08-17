package com.afonsomateus.rachahub_api.mapper;

import org.mapstruct.Mapper;

import com.afonsomateus.rachahub_api.dto.playerParticipation.PlayerParticipationRequestDTO;
import com.afonsomateus.rachahub_api.dto.playerParticipation.PlayerParticipationResponseDTO;
import com.afonsomateus.rachahub_api.entity.PlayerParticipation;

@Mapper(componentModel = "spring")
public interface PlayerParticipationMapper {
	PlayerParticipationResponseDTO toResponse(PlayerParticipation playerParticipation);
	PlayerParticipation toEntity(PlayerParticipationRequestDTO playerParticipationDTO);
}

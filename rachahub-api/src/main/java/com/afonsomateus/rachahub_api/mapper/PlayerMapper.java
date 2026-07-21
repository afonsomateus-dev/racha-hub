package com.afonsomateus.rachahub_api.mapper;

import org.mapstruct.Mapper;

import com.afonsomateus.rachahub_api.dto.player.PlayerRequestDTO;
import com.afonsomateus.rachahub_api.dto.player.PlayerResponseDTO;
import com.afonsomateus.rachahub_api.entity.Player;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
	PlayerResponseDTO toResponse(Player player);
	Player toEntity(PlayerRequestDTO playerDTO);
}

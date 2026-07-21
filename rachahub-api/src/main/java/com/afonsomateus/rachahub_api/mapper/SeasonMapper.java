package com.afonsomateus.rachahub_api.mapper;

import org.mapstruct.Mapper;

import com.afonsomateus.rachahub_api.dto.season.SeasonRequestDTO;
import com.afonsomateus.rachahub_api.dto.season.SeasonResponseDTO;
import com.afonsomateus.rachahub_api.entity.Season;

@Mapper
public interface SeasonMapper {
	SeasonResponseDTO toResponse(Season season);
	Season toEntity(SeasonRequestDTO seasonDTO);
}

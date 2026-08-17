package com.afonsomateus.rachahub_api.mapper;

import org.mapstruct.Mapper;

import com.afonsomateus.rachahub_api.dto.assist.AssistRequestDTO;
import com.afonsomateus.rachahub_api.dto.assist.AssistResponseDTO;
import com.afonsomateus.rachahub_api.entity.Assist;

@Mapper(componentModel = "spring")
public interface AssistMapper {
	AssistResponseDTO toResponse(Assist assist);
	Assist toEntity(AssistRequestDTO dto);
}

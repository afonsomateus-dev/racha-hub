package com.afonsomateus.rachahub_api.dto.season;

import java.util.UUID;

public record SeasonResponseDTO(
	UUID id, 
	int year
) {}

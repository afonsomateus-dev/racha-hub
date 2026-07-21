package com.afonsomateus.rachahub_api.dto.team;

import java.util.UUID;

public record TeamResponseDTO(
	UUID id, 
	String name
) {}

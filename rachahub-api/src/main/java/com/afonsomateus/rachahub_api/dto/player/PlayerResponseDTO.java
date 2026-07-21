package com.afonsomateus.rachahub_api.dto.player;

import java.time.LocalDate;
import java.util.UUID;

import com.afonsomateus.rachahub_api.enums.PlayerPosition;

public record PlayerResponseDTO(
	UUID id, 
	String name, 
	PlayerPosition position, 
	LocalDate birthDate
) {}

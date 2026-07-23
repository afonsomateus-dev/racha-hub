package com.afonsomateus.rachahub_api.dto.player;

import java.time.LocalDate;

import com.afonsomateus.rachahub_api.enums.PlayerPosition;
import com.afonsomateus.rachahub_api.validation.ValidEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlayerRequestDTO(
	@NotBlank(message = "Name is required")
	String name, 
	@NotNull(message = "Position is required")
	PlayerPosition position, 
	LocalDate birthDate
) {}

package com.afonsomateus.rachahub_api.dto.player;

import java.time.LocalDate;

import com.afonsomateus.rachahub_api.dto.general.OnCreate;
import com.afonsomateus.rachahub_api.enums.PlayerPosition;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlayerRequestDTO(
	@NotBlank(
		groups = OnCreate.class,
		message = "name is required."
	)
	String name, 
	@NotNull(
		groups = OnCreate.class,
		message = "position is required"
	)
	PlayerPosition position, 
	LocalDate birthDate
) {}

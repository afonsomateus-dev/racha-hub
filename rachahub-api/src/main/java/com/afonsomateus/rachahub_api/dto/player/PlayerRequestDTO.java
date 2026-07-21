package com.afonsomateus.rachahub_api.dto.player;

import java.time.LocalDate;

import com.afonsomateus.rachahub_api.enums.PlayerPosition;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlayerRequestDTO(
	@NotNull
	@NotBlank
	String name, 
	@NotNull
	PlayerPosition position, 
	LocalDate birthDate
) {}

package com.afonsomateus.rachahub_api.dto.team;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TeamRequestDTO(
	@NotNull
	@NotBlank
	String name
) {}

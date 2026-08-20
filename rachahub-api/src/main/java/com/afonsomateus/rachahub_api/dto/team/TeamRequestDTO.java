package com.afonsomateus.rachahub_api.dto.team;

import com.afonsomateus.rachahub_api.dto.general.OnCreate;

import jakarta.validation.constraints.NotBlank;

public record TeamRequestDTO(
	@NotBlank(
		groups = OnCreate.class,
		message = "name is required."
	)
	String name
) {}

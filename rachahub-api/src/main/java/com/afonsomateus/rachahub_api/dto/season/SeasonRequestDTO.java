package com.afonsomateus.rachahub_api.dto.season;

import com.afonsomateus.rachahub_api.dto.general.OnCreate;

import jakarta.validation.constraints.Positive;

public record SeasonRequestDTO(
	@Positive(
		groups = OnCreate.class,
		message = "invalid year."
	)
	int year
) {}

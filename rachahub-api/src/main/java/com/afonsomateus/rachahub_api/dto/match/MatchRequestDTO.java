package com.afonsomateus.rachahub_api.dto.match;

import java.time.LocalDate;
import java.util.UUID;

import com.afonsomateus.rachahub_api.dto.general.OnCreate;

import jakarta.validation.constraints.NotNull;

public record MatchRequestDTO(
	@NotNull(
		groups = OnCreate.class, 
		message = "seasonId is required"
	)
	UUID seasonId, 
	@NotNull(
		groups = OnCreate.class, 
		message = "title is required"
	)
	String title,
	@NotNull(
		groups = OnCreate.class, 
		message = "date is required"
	)
	LocalDate date
) {}

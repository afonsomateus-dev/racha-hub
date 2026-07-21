package com.afonsomateus.rachahub_api.dto.season;

import jakarta.validation.constraints.Positive;

public record SeasonRequestDTO(
	@Positive
	int year
) {}

package com.afonsomateus.rachahub_api.dto.teamMatch;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record TeamMatchRequestDTO(
	@NotNull
	UUID teamId,
	@NotNull
	UUID matchId,
	@PositiveOrZero
	int goals
) {}

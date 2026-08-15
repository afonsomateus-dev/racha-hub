package com.afonsomateus.rachahub_api.dto.teamMatch;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record TeamMatchRequestDTO(
	UUID teamId,
	UUID matchId,
	Integer goals
) {}

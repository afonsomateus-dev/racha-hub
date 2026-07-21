package com.afonsomateus.rachahub_api.dto.goal;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record GoalRequestDTO(
	@NotNull
	UUID playerId,
	@NotNull
	UUID matchId,
	@NotNull
	UUID teamId
) {}

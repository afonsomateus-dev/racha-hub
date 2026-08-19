package com.afonsomateus.rachahub_api.dto.assist;

import java.util.UUID;

import com.afonsomateus.rachahub_api.dto.general.OnCreate;

import jakarta.validation.constraints.NotNull;

public record AssistRequestDTO(
	@NotNull(
		groups = OnCreate.class,
		message = "playerId is required."
	)
	UUID playerId,
	@NotNull(
		groups = OnCreate.class,
		message = "matchId is required."
	)
	UUID matchId,
	@NotNull(
		groups = OnCreate.class,
		message = "teamId is required."
	)
	UUID teamId
){}

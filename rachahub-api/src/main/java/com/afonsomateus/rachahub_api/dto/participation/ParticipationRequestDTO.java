package com.afonsomateus.rachahub_api.dto.participation;

import java.util.UUID;

import com.afonsomateus.rachahub_api.dto.general.OnCreate;

import jakarta.validation.constraints.NotNull;

public record ParticipationRequestDTO(
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
) {}

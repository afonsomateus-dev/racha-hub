package com.afonsomateus.rachahub_api.dto.participation;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record ParticipationRequestDTO(
	@NotNull
	UUID matchId,
	@NotNull
	UUID teamId
) {}

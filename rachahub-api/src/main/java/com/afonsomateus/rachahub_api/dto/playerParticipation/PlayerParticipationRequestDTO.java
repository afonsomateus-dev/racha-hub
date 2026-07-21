package com.afonsomateus.rachahub_api.dto.playerParticipation;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record PlayerParticipationRequestDTO(
	@NotNull
	UUID playerId,
	@NotNull
	UUID participationId
) {}

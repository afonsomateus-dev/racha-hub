package com.afonsomateus.rachahub_api.dto.playerParticipation;

import java.util.UUID;

public record PlayerParticipationRequestDTO(
	UUID playerId,
	UUID participationId
) {}

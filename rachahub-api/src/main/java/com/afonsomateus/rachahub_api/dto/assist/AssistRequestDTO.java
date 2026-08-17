package com.afonsomateus.rachahub_api.dto.assist;

import java.util.UUID;

public record AssistRequestDTO(
	UUID playerId,
	UUID matchId,
	UUID teamId
){}

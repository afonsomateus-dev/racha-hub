package com.afonsomateus.rachahub_api.dto.playerParticipation;

import com.afonsomateus.rachahub_api.dto.participation.ParticipationResponseDTO;
import com.afonsomateus.rachahub_api.dto.player.PlayerResponseDTO;

public record PlayerParticipationResponseDTO(
	PlayerResponseDTO player,
	ParticipationResponseDTO participation
) {}

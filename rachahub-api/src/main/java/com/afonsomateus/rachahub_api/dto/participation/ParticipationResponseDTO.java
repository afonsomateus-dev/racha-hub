package com.afonsomateus.rachahub_api.dto.participation;

import java.util.UUID;

import com.afonsomateus.rachahub_api.dto.match.MatchResponseDTO;
import com.afonsomateus.rachahub_api.dto.team.TeamResponseDTO;

public record ParticipationResponseDTO(
	UUID id,
	MatchResponseDTO match,
	TeamResponseDTO team
) {}

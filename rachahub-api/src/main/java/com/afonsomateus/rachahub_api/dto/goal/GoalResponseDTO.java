package com.afonsomateus.rachahub_api.dto.goal;

import java.util.UUID;

import com.afonsomateus.rachahub_api.dto.match.MatchResponseDTO;
import com.afonsomateus.rachahub_api.dto.player.PlayerResponseDTO;
import com.afonsomateus.rachahub_api.dto.team.TeamResponseDTO;

public record GoalResponseDTO(
	UUID id,
	PlayerResponseDTO player,
	MatchResponseDTO match,
	TeamResponseDTO team
) {}

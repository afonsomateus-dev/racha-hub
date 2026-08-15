package com.afonsomateus.rachahub_api.dto.teamMatch;

import com.afonsomateus.rachahub_api.dto.match.MatchResponseDTO;
import com.afonsomateus.rachahub_api.dto.team.TeamResponseDTO;

public record TeamMatchResponseDTO(
	TeamResponseDTO team,
	MatchResponseDTO match,
	Integer goals
) {}

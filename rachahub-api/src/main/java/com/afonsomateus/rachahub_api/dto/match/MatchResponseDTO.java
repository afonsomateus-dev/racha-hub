package com.afonsomateus.rachahub_api.dto.match;

import java.time.LocalDate;
import java.util.UUID;

import com.afonsomateus.rachahub_api.dto.season.SeasonResponseDTO;

public record MatchResponseDTO(
	UUID id, 
	SeasonResponseDTO season, 
	LocalDate date
) {}

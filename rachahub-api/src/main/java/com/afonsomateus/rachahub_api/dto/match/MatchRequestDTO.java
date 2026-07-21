package com.afonsomateus.rachahub_api.dto.match;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record MatchRequestDTO(
	@NotNull 
	UUID seasonId, 
	@NotNull 
	LocalDate date
) {}

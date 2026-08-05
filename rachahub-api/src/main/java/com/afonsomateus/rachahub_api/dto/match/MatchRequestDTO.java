package com.afonsomateus.rachahub_api.dto.match;

import java.time.LocalDate;
import java.util.UUID;

public record MatchRequestDTO(
	UUID seasonId, 
	String title,
	LocalDate date
) {}

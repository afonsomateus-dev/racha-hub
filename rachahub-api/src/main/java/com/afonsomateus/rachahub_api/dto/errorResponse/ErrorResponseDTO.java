package com.afonsomateus.rachahub_api.dto.errorResponse;

public record ErrorResponseDTO(
	int status,
	String message,
	long timestamp
) {
	public ErrorResponseDTO(int status, String message) {
		this(status, message, System.currentTimeMillis());
    }
}

package com.afonsomateus.rachahub_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.afonsomateus.rachahub_api.dto.errorResponse.ErrorResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDTO> handleBadRequest(MethodArgumentNotValidException exception) {
		String message = exception.getBindingResult().getFieldError().getDefaultMessage();
		
		ErrorResponseDTO error = new ErrorResponseDTO(
			HttpStatus.BAD_REQUEST.value(),
			message
		);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponseDTO> handleHttpMessageNotReadable(HttpMessageNotReadableException exception) {
		String message = "Invalid data format";
 
	    ErrorResponseDTO error = new ErrorResponseDTO(
            HttpStatus.BAD_REQUEST.value(),
            message
	    );

	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleResourceNotFound(ResourceNotFoundException exception) {
		String message = exception.getMessage();
		
		ErrorResponseDTO error = new ErrorResponseDTO(
			HttpStatus.NOT_FOUND.value(),
			message
		);
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ErrorResponseDTO> handleUnauthorized(UnauthorizedException exception) {
		String message = exception.getMessage();
		
		ErrorResponseDTO error = new ErrorResponseDTO(
			HttpStatus.UNAUTHORIZED.value(),
			message
		);
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponseDTO> handleInternalServerError(RuntimeException exception) {
		ErrorResponseDTO error = new ErrorResponseDTO(
			HttpStatus.INTERNAL_SERVER_ERROR.value(),
			"An unexpected error occurred: " + exception.getMessage()
		);
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

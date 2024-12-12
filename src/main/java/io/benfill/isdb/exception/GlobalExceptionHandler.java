package io.benfill.isdb.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ExceptionMessage resourceNotFoundExceptionHandler(ResourceNotFoundException exception) {
		ExceptionMessage message = ExceptionMessage.builder().error(HttpStatus.NOT_FOUND.toString())
				.message(exception.getMessage()).status(HttpStatus.NOT_FOUND.value()).time(LocalDate.now()).build();
		return message;
	}

	@ExceptionHandler(SearchTypeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionMessage resourceNotFoundExceptionHandler(SearchTypeException exception) {
		ExceptionMessage message = ExceptionMessage.builder().error(HttpStatus.BAD_REQUEST.toString())
				.message(exception.getMessage()).status(HttpStatus.BAD_REQUEST.value()).time(LocalDate.now()).build();
		return message;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionMessage resourceNotFoundExceptionHandler(IllegalArgumentException exception) {
		ExceptionMessage message = ExceptionMessage.builder().error(HttpStatus.BAD_REQUEST.toString())
				.message(exception.getMessage()).status(HttpStatus.BAD_REQUEST.value()).time(LocalDate.now()).build();
		return message;
	}
}

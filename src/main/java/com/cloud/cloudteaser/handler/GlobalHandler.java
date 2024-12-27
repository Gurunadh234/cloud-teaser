package com.cloud.cloudteaser.handler;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloud.cloudteaser.exception.UnauthorizedException;
import com.cloud.cloudteaser.exception.ValidationException;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class GlobalHandler {

	@ExceptionHandler(value = UnauthorizedException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	public ErrorResponse unauthorized(UnauthorizedException ex) {
		ex.printStackTrace();
		return new ErrorResponse(LocalDateTime.now(), HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED, ex.getLocalizedMessage());
	}
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse dataIntegrityViolation(DataIntegrityViolationException ex) {
		ex.printStackTrace();
		return new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
	}
	
	@ExceptionHandler(value = ValidationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse validationExceptionHandler(ValidationException ex) {
		ex.printStackTrace();
		return new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse globalException(Exception ex) {
		ex.printStackTrace();
		return new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
	}
}

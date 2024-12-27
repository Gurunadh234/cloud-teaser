package com.cloud.cloudteaser.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
	private LocalDateTime timeStamp;
	private int status;
	private HttpStatus error;
	private String message;
}

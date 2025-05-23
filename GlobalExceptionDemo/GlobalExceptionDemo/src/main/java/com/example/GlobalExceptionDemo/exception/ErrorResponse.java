package com.example.GlobalExceptionDemo.exception;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ErrorResponse {

	private LocalDateTime timeStamp;
	private String message;
	private List<String> fieldErrors = new ArrayList<>();

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}
}

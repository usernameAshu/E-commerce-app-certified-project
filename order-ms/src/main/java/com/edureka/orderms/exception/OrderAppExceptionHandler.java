package com.edureka.orderms.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class OrderAppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception exc, WebRequest req) {

		String errorMessage = exc.getLocalizedMessage();

		if (errorMessage == null)
			errorMessage = exc.toString();

		ErrorResponse errorResponse = new ErrorResponse(errorMessage, new Date());

		return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<Object> handleNullPointerException(NullPointerException exc, WebRequest req) {

		String errorMessageDescription = exc.getLocalizedMessage();

		if (errorMessageDescription == null)
			errorMessageDescription = exc.toString();

		ErrorResponse errRes = new ErrorResponse(errorMessageDescription, new Date());

		return new ResponseEntity<>(errRes, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = { OrderNotFoundException.class })
	public ResponseEntity<Object> handleAnyException(OrderNotFoundException exc, WebRequest req) {

		String errorMessage = exc.getLocalizedMessage();

		if (errorMessage == null)
			errorMessage = exc.toString();

		ErrorResponse errorResponse = new ErrorResponse(errorMessage, new Date());

		return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

}
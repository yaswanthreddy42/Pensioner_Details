package com.cognizant.pensionerDetails.Exception;

import java.time.LocalDateTime;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.cognizant.pensionerDetails.Exception.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(PensionerExceptoin.class)
	public ResponseEntity<ErrorResponse> handlesUserNotFoundException(
			PensionerExceptoin Pensionexception) {
		ErrorResponse response = new ErrorResponse(Pensionexception.getMessage(), LocalDateTime.now(), Collections.singletonList(Pensionexception.getMessage()));
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}

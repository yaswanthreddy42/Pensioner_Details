package com.cognizant.pensionerDetails.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class PensionerExceptoin extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PensionerExceptoin(String messaage) {
		super(messaage);
		
	}

}

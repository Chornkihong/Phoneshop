package com.kihong.learn.java.phoneshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExceptionHandler {
   
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handleApiExcetion(ApiException e){
		ErrorRespone errorRespone = new ErrorRespone(e.getStatus(), e.getMessage());
		return ResponseEntity.status(e.getStatus()).body(errorRespone);
	}
}

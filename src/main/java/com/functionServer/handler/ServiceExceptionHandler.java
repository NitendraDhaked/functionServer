package com.functionServer.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.functionServer.response.FunctionResponse;

@ControllerAdvice("com.functionServer.controller")
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<FunctionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		FunctionResponse res = new FunctionResponse();
		res.setMessage(ex.getMessage());
		res.setSuccess(false);
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
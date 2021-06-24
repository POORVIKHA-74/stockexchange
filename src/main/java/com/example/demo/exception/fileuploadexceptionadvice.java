package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.message.responsemessage;

@ControllerAdvice
public class fileuploadexceptionadvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<responsemessage> handleMaxSizeException(MaxUploadSizeExceededException exc)
	{
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new responsemessage("file too large"));
	}
	

}

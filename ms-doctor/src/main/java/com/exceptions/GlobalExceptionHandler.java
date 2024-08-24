package com.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.ConstraintViolationException;


@ControllerAdvice
public class GlobalExceptionHandler {
 
	    // old method 1
	
//	@ExceptionHandler(ConstraintViolationException.class) // resquest param
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
//		List<String> details = new ArrayList<>();
//		ex.getConstraintViolations().forEach(violation -> {
//			String propertyPath = violation.getPropertyPath().toString();
//			String propertyName = propertyPath.substring(propertyPath.lastIndexOf('.') + 1);
//			String errorMessage = violation.getMessage();
//			details.add(propertyName + " | " + errorMessage);
//
//		});
//		ErrorResponse error = new ErrorResponse("Validation Failed", details);
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(CustomException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public ResponseEntity<?> handleCustomException(CustomException ex) {
//		List<String> details = new ArrayList<>();
//		details.add("cause: " + ex.getMessage());
//		ErrorResponse error = new ErrorResponse("Data Not Available", details);
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}
//
//	
//	 @ExceptionHandler(MethodArgumentNotValidException.class) public
//	  ResponseEntity<Object>
//	  handleValidationExceptions(MethodArgumentNotValidException ex) { List<String>
//	  details = new ArrayList<>();
//	  ex.getBindingResult().getAllErrors().forEach((error) -> { String fieldName =
//	  ((FieldError) error).getField(); String errorMessage =
//	  error.getDefaultMessage(); details.add(fieldName + "|" + errorMessage); });
//	  ErrorResponse error = new ErrorResponse("Validation Failed", details); return
//	  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); }
	 
	 
	 
	   // old method modification with respect to new code 
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
	    List<String> details = new ArrayList<>();
	    ex.getConstraintViolations().forEach(violation -> {
	        String propertyPath = violation.getPropertyPath().toString();
	        String propertyName = propertyPath.substring(propertyPath.lastIndexOf('.') + 1);
	        String errorMessage = violation.getMessage();
	        details.add(propertyName + " | " + errorMessage);
	    });
	    ErrorResponse error = new ErrorResponse("Validation Failed: " + String.join(", ", details));
	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
	    ErrorResponse error = new ErrorResponse("Data Not Available: " + ex.getMessage());
	    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    List<String> details = new ArrayList<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        details.add(fieldName + "|" + errorMessage);
	    });
	    ErrorResponse error = new ErrorResponse("Validation Failed: " + String.join(", ", details));
	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResponseStatusException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> handleResponseStatusException(ResponseStatusException ex) {
	    ErrorResponse error = new ErrorResponse(ex.getMessage());
	    return new ResponseEntity<>(error, ex.getStatusCode());
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 // new  method 2
	 
	 
//	 @ExceptionHandler(Exception.class)
//	    public ResponseEntity<ErrorResponse> handleException(Exception e) {
//	        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//	    }
//
//	    @ExceptionHandler(NotFoundException.class)
//	    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
//	        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//	    }
//
//	    @ExceptionHandler(BadRequestException.class)
//	    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
//	        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//	    } 


	 
	 
	 
	// new  method 1

	 
//	 @ExceptionHandler(Exception.class)
//	    public ResponseEntity<ErrorResponse> handleException(Exception e) {
//	        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), e.getClass().getName());
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//	    }
//
//	    @ExceptionHandler(NotFoundException.class)
//	    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
//	        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), e.getClass().getName());
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//	    }
//
//	    @ExceptionHandler(BadRequestException.class)
//	    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
//	        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), e.getClass().getName());
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//	    } 

 
	 
}

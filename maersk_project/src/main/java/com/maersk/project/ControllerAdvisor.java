package com.maersk.project;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleCityNotFoundException(
        Exception ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "HTTP 500 INTERNAL SERVER ERROR.");

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }


	/*
	 * @Override protected ResponseEntity<Object> handleMethodArgumentNotValid(
	 * MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
	 * WebRequest request) {
	 * 
	 * Map<String, Object> body = new LinkedHashMap<>(); body.put("timestamp",
	 * LocalDate.now()); body.put("status", status.value()); List<String> errors =
	 * ex.getBindingResult() .getFieldErrors() .stream() .map(x ->
	 * x.getDefaultMessage()) .collect(Collectors.toList());
	 * 
	 * 
	 * body.put("errors", errors);
	 * 
	 * return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST); }
	 */
}

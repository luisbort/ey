package com.ey.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({GlobalException.class})
    public ResponseEntity<Object> globalExceptionHandler(final GlobalException ex, final WebRequest request) {

        final ApiError apiError = new ApiError(ex.getMessage());
        return new ResponseEntity<Object>(apiError, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder errorMessage = new StringBuilder("");
        ex.getBindingResult().getAllErrors().forEach(c -> errorMessage.append(c.getDefaultMessage()).append(";"));

        final ApiError apiError = new ApiError(errorMessage.toString());
        return new ResponseEntity<Object>(apiError, HttpStatus.BAD_REQUEST);
    }
}

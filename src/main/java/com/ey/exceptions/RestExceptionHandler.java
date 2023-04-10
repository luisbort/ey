package com.ey.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({GlobalException.class})
    public ResponseEntity<Object> handleConstraintViolation(final GlobalException ex, final WebRequest request) {

        final ApiError apiError = new ApiError(ex.getMessage());
        return new ResponseEntity<Object>(apiError, HttpStatus.BAD_REQUEST);
    }

}

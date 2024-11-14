package com.multimodels.user.exceptionHandler;

import com.multimodels.user.validator.UserFieldConstraints;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerApp {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseException> handleRuntimeException(RuntimeException exception) {

        log.info(exception.getMessage());
        return new ResponseEntity<ResponseException>(new ResponseException(exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationErrorResponse> onConstraintValidationException(ConstraintViolationException e) {
        log.info(e.getMessage());
        final List<Violation> violations = e.getConstraintViolations().stream()
                .map(
                        violation -> new Violation(
                                violation.getPropertyPath().toString(),
                                violation.getMessage()
                        )
                )
                .collect(Collectors.toList());
        return new ResponseEntity<ValidationErrorResponse>(new ValidationErrorResponse(violations),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.info(e.getMessage());
        final List<Violation> violations = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new Violation(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        return new ResponseEntity<ValidationErrorResponse>(new ValidationErrorResponse(violations),
                HttpStatus.BAD_REQUEST);

    }

}

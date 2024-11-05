package com.multimodels.user.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerApp {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseException> handleRuntimeException(RuntimeException exception) {
        log.info(exception.getMessage());
        return new ResponseEntity<ResponseException>(new ResponseException(exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

}

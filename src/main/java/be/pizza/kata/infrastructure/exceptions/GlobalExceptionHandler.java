package be.pizza.kata.infrastructure.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            ConstraintViolationException.class,
    })
    public ResponseEntity<Object> handleConstraintViolations(ConstraintViolationException ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> exception : ex.getConstraintViolations()) {
            errors.put(exception.getPropertyPath().toString(), exception.getMessage());
        }

        return ResponseEntity.badRequest().body(errors);
    }
}

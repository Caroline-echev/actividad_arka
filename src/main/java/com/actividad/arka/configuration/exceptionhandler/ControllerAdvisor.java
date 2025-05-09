package com.actividad.arka.configuration.exceptionhandler;

import com.actividad.arka.domain.exception.notfound.CategoryNotFoundException;
import com.actividad.arka.domain.exception.notfound.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionCodeResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getFieldErrors().get(0);
        return ResponseEntity.badRequest().body(new ExceptionCodeResponse(HttpStatus.BAD_REQUEST.value(), fieldError.getDefaultMessage(), HttpStatus.BAD_REQUEST.name(), LocalDateTime.now()));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionCodeResponse> handleCategoryNotFoundException(CategoryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionCodeResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), HttpStatus.NOT_FOUND.name(), LocalDateTime.now())
        );
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionCodeResponse> handleProductNotFoundException(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionCodeResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), HttpStatus.NOT_FOUND.name(), LocalDateTime.now())
        );
    }


}

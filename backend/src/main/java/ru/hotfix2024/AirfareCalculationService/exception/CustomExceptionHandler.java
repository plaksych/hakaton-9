package ru.hotfix2024.AirfareCalculationService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    // Прописать JSON, возвращаемый при возникновении исключения EntityNotFoundException, при возникновении любого другого исключения должен выводиться текст ошибки.
    @ExceptionHandler
    ResponseEntity<CustomNotFoundErrorDescription> catchEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>(new CustomNotFoundErrorDescription(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    ResponseEntity<CustomNotFoundErrorDescription> catchException(Exception e) {
        return new ResponseEntity<>(new CustomNotFoundErrorDescription(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}

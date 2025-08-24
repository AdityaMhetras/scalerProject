package dev.aditya.productservice.exceptions;

import dev.aditya.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerAdvices {

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(NotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException e) {
//
//        return new ResponseEntity(
//                new ExceptionDto(e.getMessage(), HttpStatus.NOT_FOUND),
//                HttpStatus.NOT_FOUND
//        );
//    }

//    @ExceptionHandler(Exception.class)
//    private ResponseEntity<String> handleAllExceptions(Exception e) {
//
//        return new ResponseEntity<>(
//                e.getMessage(),
//                HttpStatus.INTERNAL_SERVER_ERROR
//        );
//    }
}

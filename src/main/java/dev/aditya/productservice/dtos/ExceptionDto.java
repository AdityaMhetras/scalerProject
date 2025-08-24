package dev.aditya.productservice.dtos;

import org.springframework.http.HttpStatus;

public record ExceptionDto (String message,HttpStatus status) {

}

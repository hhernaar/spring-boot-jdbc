package com.hhernaar.jdbc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.hhernaar.jdbc.dto.GenericResponseDto;
import com.hhernaar.jdbc.util.Response;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public GenericResponseDto notFoundException(NotFoundException ex) {
    return Response.error(ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public GenericResponseDto exception(Exception ex) {
    return Response.error();
  }

}

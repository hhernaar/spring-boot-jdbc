package com.hhernaar.jdbc.util;

import com.hhernaar.jdbc.dto.GenericResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Response {

  private String CREATE_MSG = "El registo se creo correctamente.";
  private String UPDATE_MSG = "Registro actualizado con \u00e9xito.";
  private String DELETE_MSG = "Se elimino correctamente el registro.";
  private String GENERIC_ERROR = "Ops! error no controlado.";

  public GenericResponseDto create(Object data) {
    return new GenericResponseDto(CREATE_MSG, data);
  }

  public GenericResponseDto update(Object data) {
    return new GenericResponseDto(UPDATE_MSG, data);
  }

  public GenericResponseDto delete() {
    return new GenericResponseDto(DELETE_MSG);
  }

  public GenericResponseDto error(String msg) {
    return new GenericResponseDto(msg);
  }

  public GenericResponseDto error() {
    return new GenericResponseDto(GENERIC_ERROR);
  }

}

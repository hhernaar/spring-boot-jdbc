package com.hhernaar.jdbc.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

/**
 * Object that represents a generic response.
 * 
 * @author hhernaar
 */
@Data
@JsonInclude(value = Include.NON_EMPTY)
public class GenericResponseDto implements Serializable {
  private static final long serialVersionUID = 1L;

  public String msg;
  public Object data;


  public GenericResponseDto(String msg) {
    this.msg = msg;
  }

  public GenericResponseDto(String msg, Object data) {
    this.msg = msg;
    this.data = data;
  }

}

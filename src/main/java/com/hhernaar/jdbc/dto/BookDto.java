package com.hhernaar.jdbc.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * The Book Representation.
 */
@Data
public class BookDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long bookId;
  private String title;
  private String author;
  private Integer pages;
  private String isbn;

}

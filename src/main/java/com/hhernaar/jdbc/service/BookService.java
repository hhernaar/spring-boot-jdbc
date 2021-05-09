package com.hhernaar.jdbc.service;

import java.util.List;
import com.hhernaar.jdbc.dto.BookDto;
import com.hhernaar.jdbc.exception.NotFoundException;

/**
 * Book Service
 * 
 * Service in charge to manage books in the repo.
 */
public interface BookService {


  /**
   * Create or Update Book in DB.
   * 
   * @param bookDto The DTO that represents specific book {@link BookDto}
   * @return The new item.
   */
  public BookDto createUpdate(BookDto bookDto);


  /**
   * Find specific book by its id.
   * 
   * @param bookId The Book ID.
   * @return The item.
   * @throws NotFoundException
   */
  public BookDto find(Long bookId) throws NotFoundException;


  /**
   * list all books in DB.
   * 
   * @return List of books.
   */
  public List<BookDto> list();


  /**
   * Delete specific book by its id.
   * 
   * @param bookId The Book ID.
   */
  public void delete(Long bookId);

}

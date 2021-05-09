package com.hhernaar.jdbc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.hhernaar.jdbc.dto.BookDto;
import com.hhernaar.jdbc.dto.GenericResponseDto;
import com.hhernaar.jdbc.exception.NotFoundException;
import com.hhernaar.jdbc.service.BookService;
import com.hhernaar.jdbc.util.Response;

@RestController
@RequestMapping("/book")
public class BookController {

  @Autowired
  private BookService bookService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public GenericResponseDto create(@RequestBody BookDto bookDto) {
    return Response.create(bookService.createUpdate(bookDto));
  }

  @GetMapping
  public List<BookDto> list() {
    return bookService.list();
  }

  @GetMapping("/{bookId}")
  public BookDto find(@PathVariable("bookId") Long bookId) throws NotFoundException {
    return bookService.find(bookId);
  }

  @PutMapping("/{bookId}")
  public GenericResponseDto update(@PathVariable("bookId") Long bookId,
      @RequestBody BookDto bookDto) {
    bookDto.setBookId(bookId);
    return Response.update(bookService.createUpdate(bookDto));
  }

  @DeleteMapping("/{bookId}")
  public GenericResponseDto delete(@PathVariable("bookId") Long bookId) {
    bookService.delete(bookId);
    return Response.delete();
  }
}

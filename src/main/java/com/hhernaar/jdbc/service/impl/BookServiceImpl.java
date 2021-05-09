package com.hhernaar.jdbc.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hhernaar.jdbc.dao.BookDao;
import com.hhernaar.jdbc.dto.BookDto;
import com.hhernaar.jdbc.exception.NotFoundException;
import com.hhernaar.jdbc.service.BookService;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookDao bookDao;

  @Autowired
  private ObjectMapper mapper;

  @Override
  public BookDto createUpdate(BookDto bookDto) {
    return mapper.convertValue(bookDao.createUpdate(bookDto.getBookId(), bookDto.getTitle(),
        bookDto.getAuthor(), bookDto.getPages(), bookDto.getIsbn()), BookDto.class);
  }

  @Override
  public BookDto find(Long bookId) throws NotFoundException {
    List<Map<String, Object>> lstResult = bookDao.find(bookId);
    if (lstResult == null || lstResult.isEmpty()) {
      throw new NotFoundException("No se encontro el libro indicado.");
    }
    return mapper.convertValue(lstResult.get(0), BookDto.class);
  }

  @Override
  public List<BookDto> list() {
    return bookDao.find(new Object[] {null}).stream()
        .map(book -> mapper.convertValue(book, BookDto.class)).collect(Collectors.toList());
  }

  @Override
  public void delete(Long bookId) {
    bookDao.delete(bookId);
  }

}

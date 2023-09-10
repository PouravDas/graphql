package com.test.graphql.service;

import com.test.graphql.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

  Book createBook(Book book);

  Book updateBook(int id, Map<String, ?> bookMap);

  List<Book> getAllBooks();

  Book getBook(int id);

  void deleteBook(int id);
}

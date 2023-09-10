package com.test.graphql.controller;

import com.test.graphql.entity.Book;
import com.test.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rest/v1/api")
public class SimpleRestController {

  @Autowired
  BookService bookService;

  @GetMapping("test")
  public String testAPI() {
    return "Success";
  }

  @PostMapping("books")
  public Book create(@RequestBody Book book) {
    return bookService.createBook(book);
  }

  @PostMapping("books/{id}")
  public Book create(@PathVariable int id, @RequestBody Map<String,?> bookMap) {
    return bookService.updateBook(id, bookMap);
  }

  @GetMapping("books/{id}")
  public Book getBook(@PathVariable int id) {
    return bookService.getBook(id);
  }

  @GetMapping("books")
  public List<Book> getBook() {
    return bookService.getAllBooks();
  }
}

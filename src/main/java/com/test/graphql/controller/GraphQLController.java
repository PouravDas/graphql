package com.test.graphql.controller;

import com.test.graphql.entity.Book;
import com.test.graphql.service.BookService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller public class GraphQLController {

  @Autowired BookService bookService;

  @QueryMapping("allBooks") public List<Book> getBooks () {
    return bookService.getAllBooks();
  }

  @QueryMapping("getBook") public Book getBookById (@Argument int id) {
    return bookService.getBook(id);
  }

  @MutationMapping("create") public Book createBook (@Argument BookInput bookInput) {
    Book book = new Book();
    book.setPrice(bookInput.getPrice());
    book.setPages(bookInput.getPages());
    book.setDescription(bookInput.getDescription());
    book.setTitle(bookInput.getTitle());
    return bookService.createBook(book);
  }

  @Getter
  @Setter
  static class BookInput {
    private String title;
    private String description;
    private int pages;
    private double price;
  }
}

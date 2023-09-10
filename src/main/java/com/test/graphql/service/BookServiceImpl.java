package com.test.graphql.service;

import com.test.graphql.entity.Book;
import com.test.graphql.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service public class BookServiceImpl implements BookService {

  @Autowired BookRepo bookRepo;

  @Override public Book createBook (Book book) {
    return bookRepo.save(book);
  }

  @Override public Book updateBook (int id, Map<String, ?> bookMap) {
    Book bookOrg = bookRepo.findById(id).get();
    if (bookOrg != null && bookMap != null) {
      bookMap.entrySet().forEach(e -> {
        if (!e.getKey().equals("id")) {
          try {
            Field field = Book.class.getDeclaredField(e.getKey());
            field.setAccessible(true);
            field.set(bookOrg, e.getValue());

          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      });
    }
    return bookOrg;
  }

  @Override public List<Book> getAllBooks () {
    return bookRepo.findAll();
  }

  @Override public Book getBook (int id) {
    return bookRepo.findById(id).get();
  }

  @Override public void deleteBook (int id) {
    bookRepo.deleteById(id);
  }
}

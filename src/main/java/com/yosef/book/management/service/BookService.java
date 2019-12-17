package com.yosef.book.management.service;

import com.yosef.book.management.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooksList();
    Optional<Book> getBookById(Long id);
    void deleteBook(Long id);
}

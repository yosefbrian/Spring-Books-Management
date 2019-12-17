package com.yosef.book.management.service;

import com.yosef.book.management.entities.Book;
import com.yosef.book.management.exception.ExistException;
import com.yosef.book.management.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooksList();
    Optional<Book> getBookById(Long id) throws NotFoundException;
    void deleteBook(Long id) throws NotFoundException;
    Book addNewBook(Book book) throws ExistException;
    Book updateBook(Long id, Book book) throws  NotFoundException;
}

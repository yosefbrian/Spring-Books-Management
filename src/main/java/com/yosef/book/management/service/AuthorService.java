package com.yosef.book.management.service;

import com.yosef.book.management.entities.Author;
import com.yosef.book.management.exception.NotFoundException;

public interface AuthorService {
    Author addAuthorBasedOnBook(Long bookId, Author author) throws NotFoundException;
}

package com.yosef.book.management.service;

import com.yosef.book.management.entities.Author;

public interface AuthorService {
    Author addAuthorBasedOnBook(Long bookId, Author author);
}

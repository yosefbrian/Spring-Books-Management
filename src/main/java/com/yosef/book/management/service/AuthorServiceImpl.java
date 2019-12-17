package com.yosef.book.management.service;

import com.yosef.book.management.entities.Author;
import com.yosef.book.management.entities.Book;
import com.yosef.book.management.exception.NotFoundException;
import com.yosef.book.management.repository.AuthorRepository;
import com.yosef.book.management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository)  {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Author addAuthorBasedOnBook(Long bookId, Author author) throws NotFoundException {
        Optional<Book> book = bookRepository.findById(bookId);

        if (!book.isPresent()){
            throw new NotFoundException("book not found");
        }
        author.setBook(book.get());
        return authorRepository.save(author);
    }
}

package com.yosef.book.management.service;

import com.yosef.book.management.entities.Book;
import com.yosef.book.management.exception.ExistException;
import com.yosef.book.management.exception.NotFoundException;
import com.yosef.book.management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooksList() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) throws NotFoundException {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent()){
            throw new NotFoundException("Book Not Found");
        }
        return book;
    }

    @Override
    public void deleteBook(Long id) throws NotFoundException {
        if (!bookRepository.findById(id).isPresent()){
            throw new NotFoundException("Book Not Found");
        }
        bookRepository.deleteById(id);
    }

    @Override
    public Book addNewBook(Book book) throws ExistException {
        if (bookRepository.findByTitle(book.getTitle()) != null){
            throw new ExistException("book already Exist");
        }
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) throws NotFoundException {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (!existingBook.isPresent()){
            throw new NotFoundException("Book Not Found");
        }
        book.setId(id);
        return bookRepository.save(book);
    }
}

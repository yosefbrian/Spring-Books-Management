package com.yosef.book.management.controller;

import com.yosef.book.management.entities.Book;
import com.yosef.book.management.exception.ExistException;
import com.yosef.book.management.exception.NotFoundException;
import com.yosef.book.management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooksList(){
        return bookService.getBooksList();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Long id){
        try {
            return bookService.getBookById(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id){
        try {
            bookService.deleteBook(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Void> addNewBook(@Valid  @RequestBody Book book, UriComponentsBuilder builder){
        try {
            Book created = bookService.addNewBook(book);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/books/{id}").buildAndExpand(created.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (ExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book book){
        try {
            return bookService.updateBook(id, book);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}

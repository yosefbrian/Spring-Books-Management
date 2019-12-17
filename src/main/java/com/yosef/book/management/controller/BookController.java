package com.yosef.book.management.controller;

import com.yosef.book.management.entities.Book;
import com.yosef.book.management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
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
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
    }

    @PostMapping
    public Book addNewBook(@RequestBody Book book){
        return bookService.addNewBook(book);
    }
}

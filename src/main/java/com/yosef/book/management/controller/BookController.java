package com.yosef.book.management.controller;

import com.yosef.book.management.entities.Book;
import com.yosef.book.management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

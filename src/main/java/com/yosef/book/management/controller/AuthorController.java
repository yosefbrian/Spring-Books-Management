package com.yosef.book.management.controller;

import com.yosef.book.management.entities.Author;
import com.yosef.book.management.exception.NotFoundException;
import com.yosef.book.management.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/book/{id}")
    public Author addAuthorByBook(@PathVariable("id") Long id, @RequestBody Author author){
        try {
            return authorService.addAuthorBasedOnBook(id, author);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}

package com.yosef.book.management.controller;

import com.yosef.book.management.entities.Author;
import com.yosef.book.management.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return authorService.addAuthorBasedOnBook(id, author);
    }
}

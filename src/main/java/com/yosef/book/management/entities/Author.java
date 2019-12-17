package com.yosef.book.management.entities;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long author_id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;
}

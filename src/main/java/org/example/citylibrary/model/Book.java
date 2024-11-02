package org.example.citylibrary.model;

import jakarta.persistence.*;

@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id")
    private int bookId;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher publisher; // Book -X-------||- Publisher
}

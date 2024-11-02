package org.example.citylibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id")
    private int bookId;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher publisher; // Book -X-------||- Publisher
}

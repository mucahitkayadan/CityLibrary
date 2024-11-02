package org.example.citylibrary.model;

import jakarta.validation.constraints.NotBlank;
import org.example.citylibrary.model.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    @NotBlank(message = "Not null - no empty - no blank")
    private String isbn;

    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Author> authors;

    public Book(String title) {
        this.title = title;
    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", publisher=" + publisher +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

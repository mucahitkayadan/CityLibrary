package org.example.citylibrary.repository;

import org.example.citylibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findBookByIsbn(String isbn);
}

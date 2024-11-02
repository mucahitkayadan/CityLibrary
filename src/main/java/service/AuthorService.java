package service;

import org.example.citylibrary.model.Author;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> addNewAuthor(Author author);
}

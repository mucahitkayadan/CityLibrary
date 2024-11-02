package service.impl;

import lombok.RequiredArgsConstructor;
import org.example.citylibrary.model.Author;
import org.example.citylibrary.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import service.AuthorService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Optional<Author> addNewAuthor(Author author) {
        Author newAuthor = authorRepository.save(author);
        return Optional.of(newAuthor);
    }
}

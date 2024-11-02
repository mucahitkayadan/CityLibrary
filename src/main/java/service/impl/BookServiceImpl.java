package service.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.citylibrary.model.Book;
import org.example.citylibrary.repository.BookRepository;
import org.springframework.stereotype.Service;
import service.BookService;

import org.example.citylibrary.repository.BookRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Optional<Book> addNewBook(Book book) {
        Book newBook = bookRepository.save(book);
        return Optional.of(newBook);
    }

    @Override
    public Optional<Book> updateBook(Book book) {
        return Optional.empty(); //needs to be impl
    }

    @Override
    public Optional<Book> findBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }
}

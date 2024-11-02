package service;
import org.example.citylibrary.model.Book;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BookService {
    Optional<Book> addNewBook(Book book);
    Optional<Book> updateBook(Book book);
    Optional<Book> findBookByIsbn(String isbn);
}

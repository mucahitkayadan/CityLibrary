package org.example.citylibrary;

import org.example.citylibrary.repository.AuthorRepository;
import org.example.citylibrary.repository.BookRepository;
import org.example.citylibrary.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.example.citylibrary.model.Address;
import org.example.citylibrary.model.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import org.example.citylibrary.model.*;

@SpringBootApplication
@RequiredArgsConstructor
public class CityLibraryApplication {
	private final PublisherRepository publisherRepository;
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(CityLibraryApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			//create a publisher object
			Publisher publisher = new Publisher("Muja Kayadan");
			Address address = new Address("2000 N", "Fairfield", "IA", 52556);
			publisher.setPrimaryAddress(address);
			Publisher savedPublisher = publisherRepository.save(publisher);
			System.out.println(savedPublisher + " is saved");

//			Optional<Publisher> foundPublisher = publisherRepository.findByPublisherName("Muja Kayadan");
//            foundPublisher.ifPresent(value -> System.out.println(value + " is found"));
//
//			// Update publisher name
//			publisherRepository.findByPublisherName("Muja Kayadan").ifPresent(
//					publisher1 -> {
//						System.out.println(publisher1 + " is found");
//						publisher.setPublisherName("Muja");
//					}
//					);
//		};
			// create 3 books
			Book book1 = new Book("1234567890", "The Great Gatsby");
			Book book2 = new Book("9876543210", "To Kill a Mockingbird");
			Book book3 = new Book("5555555555", "1984");

			// set existing publisher to the books
			book1.setPublisher(publisher);
			book2.setPublisher(publisher);
			book3.setPublisher(publisher);

			//create s few authors and save them
			Author author1 = new Author("John Doe", "john.doe@example.com");
			Author author2 = new Author("Jane Doe", "jane.doe@example.com");
			authorRepository.save(author1);
			authorRepository.save(author2);

			// set multiple for every book
			book1.setAuthors(Arrays.asList(author1, author2));
			book2.setAuthors(Arrays.asList(author1, author2));
			book3.setAuthors(Arrays.asList(author1, author2));

			// save books to the database
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);

			//display all books
			List<Book> books = bookRepository.findAll();
			books.forEach(System.out::println);
		};
	}
}

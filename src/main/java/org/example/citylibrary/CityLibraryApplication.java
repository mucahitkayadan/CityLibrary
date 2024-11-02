package org.example.citylibrary;

import org.example.citylibrary.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.example.citylibrary.model.Address;
import org.example.citylibrary.model.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CityLibraryApplication {
	private final PublisherRepository publisherRepository;

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

			Optional<Publisher> foundPublisher = publisherRepository.findByPublisherName("Muja Kayadan");
            foundPublisher.ifPresent(value -> System.out.println(value + " is found"));

			// Update publisher name
			publisherRepository.findByPublisherName("Muja Kayadan").ifPresent(
					publisher1 -> {
						System.out.println(publisher1 + " is found");
						publisher.setPublisherName("Muja");
					}
					);
		};
	}
}

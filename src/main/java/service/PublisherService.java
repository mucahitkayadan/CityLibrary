package service;

import java.util.List;
import java.util.Optional;
import org.example.citylibrary.model.Publisher;
import org.example.citylibrary.model.Address;

public interface PublisherService {
    Optional<Publisher> addNewPublisher(Publisher publisher);
    Optional<Publisher> getPublisher(String publisherName);
    Optional<Publisher> findByPublisherName(String publisherName);
    void deletePublisher(String publisherName);
    Optional<Publisher> updatePublisher(String publisherName, Publisher publisher);
    Optional<Publisher> updatePublisherName(String publisherName, Publisher publisher);
    Optional<Publisher> updatePublisherAddress(String publisherName, Address publisherAddress);
}

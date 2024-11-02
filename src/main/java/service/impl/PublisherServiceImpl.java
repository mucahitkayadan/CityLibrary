package service.impl;

import lombok.RequiredArgsConstructor;
import org.example.citylibrary.model.Address;
import org.example.citylibrary.repository.PublisherRepository;
import org.example.citylibrary.model.Publisher;
import org.springframework.stereotype.Service;
import service.PublisherService;
import java.util.List;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    @Override
    public Optional<Publisher> addNewPublisher(Publisher publisher) {
        Publisher savedPublisher = publisherRepository.save(publisher);
        return Optional.of(savedPublisher);
    }

    @Override
    public Optional<Publisher> getPublisher(String publisherName) {
        return publisherRepository.findByPublisherName(publisherName);
    }

    @Override
    public Optional<Publisher> findByPublisherName(String publisherName) {
        return publisherRepository.findByPublisherName(publisherName);
    }

    @Override
    public void deletePublisher(String publisherName) {
        publisherRepository.findByPublisherName(publisherName).ifPresent(publisherRepository::delete);
    }

    @Override
    public Optional<Publisher> updatePublisher(String publisherName, Publisher publisher) {
        publisherRepository.findByPublisherName(publisherName)
                .ifPresent(publisher1 -> {
                    publisher1.setPublisherName(publisherName);
                    publisher1.setPrimaryAddress(publisher.getPrimaryAddress());
                });
        return Optional.of(publisherRepository.save(publisher));
    }

    @Override
    public Optional<Publisher> updatePublisherName(String publisherName, Publisher publisher) {
        Optional<Publisher> foundPublisher = publisherRepository.findByPublisherName(publisherName);
        foundPublisher.ifPresent(publisher1 -> publisher1.setPublisherName(publisher1.getPublisherName()));
        return foundPublisher;
    }

    @Override
    public Optional<Publisher> updatePublisherAddress(String publisherName, Address publisherAddress) {
        Optional<Publisher> foundPublisher = publisherRepository.findByPublisherName(publisherName);
        foundPublisher.ifPresent(publisher1 -> publisher1.setPrimaryAddress(publisher1.getPrimaryAddress()));
        return foundPublisher;
    }
}

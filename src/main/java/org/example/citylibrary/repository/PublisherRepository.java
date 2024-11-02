package org.example.citylibrary.repository;

import org.example.citylibrary.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface PublisherRepository extends JpaRepository <Publisher, Integer> {
    Optional<List<Publisher>> findByPublisherName(String publisherName);
}
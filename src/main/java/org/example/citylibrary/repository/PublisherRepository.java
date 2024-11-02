package org.example.citylibrary.repository;

import org.example.citylibrary.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository <Publisher, Integer> {
    Optional<Publisher> findByPublisherName(String publisherName);
}
package org.example.citylibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "authors")
public class Author {
    @Id
    private Integer authorId;
    private String authorName;
    private String authorLastname;

    public Author(String authorName, String authorLastname) {
        this.authorName = authorName;
        this.authorLastname = authorLastname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
                ", authorLastname='" + authorLastname + '\'' +
                '}';
    }
}

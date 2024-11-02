package org.example.citylibrary.model;
import org.example.citylibrary.model.Book;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer publisherId;

    @Column(name = "publisher_name")
    private String publisherName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address primaryAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "publishers")
    private List<Book> books;

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", publisherName='" + publisherName + '\'' +
                ", primaryAddress=" + primaryAddress +
                '}';
    }
}

package org.milianz.p2.Domain.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private  String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column
    private Integer publicationYear;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = false)
    private String genre;

}

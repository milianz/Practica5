package org.milianz.p2.Repository;

import org.milianz.p2.Domain.Entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface iBookRepository extends iGenericRepository<Book, UUID> {

    List<Book> findAllByAuthor(String author);
    List<Book> findAllByLanguage(String language);
    List<Book> findAllByGenre(String genre);
    Book findByIsbn(String isbn);

    @Query("SELECT b FROM Book b WHERE b.pages BETWEEN :min AND :max")
    List<Book> findByPagesBetween(@Param("min") Integer min, @Param("max") Integer max);
}
package org.milianz.p2.Service;

import org.milianz.p2.Domain.DTOs.CreateBookDTO;
import org.milianz.p2.Domain.Entities.Book;

import java.util.List;

public interface iBookService {

    Book findBookByIsbn(String isbn);
    List<Book> findByAuthor(String author);
    List<Book> findByLanguage(String language);
    List<Book> findByGenre(String genre);
    List<Book> findByPagesBetween(Integer min, Integer max);
    List<Book> findAllBooks();
    void createBook(CreateBookDTO createBookDTO);
    void updateBookLanguage(String isbn, String newLanguage);
    void updateBookTitle(String isbn, String newTitle);
    void deleteBook(String isbn);
}
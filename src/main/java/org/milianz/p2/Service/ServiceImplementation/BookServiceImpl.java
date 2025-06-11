package org.milianz.p2.Service.ServiceImplementation;

import lombok.RequiredArgsConstructor;
import org.milianz.p2.Domain.DTOs.CreateBookDTO;
import org.milianz.p2.Domain.Entities.Book;
import org.milianz.p2.Exceptions.BookAlreadyExistsException;
import org.milianz.p2.Exceptions.BookNotFoundException;
import org.milianz.p2.Exceptions.InvalidBookDataException;
import org.milianz.p2.Repository.iBookRepository;
import org.milianz.p2.Service.iBookService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements iBookService {

    private final iBookRepository bookRepository;

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public List<Book> findByAuthor(String authorName) {
        return bookRepository.findAllByAuthor(authorName);
    }

    @Override
    public List<Book> findByLanguage(String language) {
        return bookRepository.findAllByLanguage(language);
    }

    @Override
    public List<Book> findByGenre(String genre) {
        return bookRepository.findAllByGenre(genre);
    }

    @Override
    public List<Book> findByPagesBetween(Integer min, Integer max) {
        return bookRepository.findByPagesBetween(min, max);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void createBook(CreateBookDTO createBookDTO) {
        if (bookRepository.findByIsbn(createBookDTO.getIsbn()) != null) {
            throw new BookAlreadyExistsException("Ya existe un libro con el ISBN: " + createBookDTO.getIsbn());
        }

        int currentYear = LocalDate.now().getYear();
        if (createBookDTO.getPublicationYear() > currentYear) {
            throw new InvalidBookDataException("El año de publicación no puede ser mayor al año actual");
        }

        if (createBookDTO.getTitle().matches("^\\d+$")) {
            throw new InvalidBookDataException("El título no puede contener solo números");
        }

        if (createBookDTO.getPages() <= 10) {
            throw new InvalidBookDataException("El número de páginas debe ser mayor a 10");
        }

        Book book = new Book();
        book.setTitle(createBookDTO.getTitle());
        book.setAuthor(createBookDTO.getAuthor());
        book.setIsbn(createBookDTO.getIsbn());
        book.setPublicationYear(createBookDTO.getPublicationYear());
        book.setLanguage(createBookDTO.getLanguage());
        book.setPages(createBookDTO.getPages());
        book.setGenre(createBookDTO.getGenre());

        bookRepository.save(book);
    }

    @Override
    public void updateBookLanguage(String isbn, String newLanguage) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            book.setLanguage(newLanguage);
            bookRepository.save(book);
        } else {
            throw new BookNotFoundException("El libro con ISBN: " + isbn + " no se pudo encontrar.");
        }
    }

    @Override
    public void updateBookTitle(String isbn, String newTitle) {
        if (newTitle.matches("^\\d+$")) {
            throw new InvalidBookDataException("El título no puede contener solo números");
        }

        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            book.setTitle(newTitle);
            bookRepository.save(book);
        } else {
            throw new BookNotFoundException("El libro con ISBN: " + isbn + " no se pudo encontrar.");
        }
    }

    @Override
    public void deleteBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            bookRepository.delete(book);
        } else {
            throw new BookNotFoundException("El libro con ISBN: " + isbn + " no se pudo encontrar.");
        }
    }
}
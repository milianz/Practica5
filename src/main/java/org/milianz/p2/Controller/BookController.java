package org.milianz.p2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.milianz.p2.Domain.DTOs.CreateBookDTO;
import org.milianz.p2.Domain.DTOs.UpdateBookDTO;
import org.milianz.p2.Domain.Entities.Book;
import org.milianz.p2.Service.iBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {

    private final iBookService bookService;

    @PostMapping
    public ResponseEntity<String> createBook(@Valid @RequestBody CreateBookDTO createBookDTO) {
        try {
            bookService.createBook(createBookDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Libro creado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        try {
            Book book = bookService.findBookByIsbn(isbn);
            if (book != null) {
                return ResponseEntity.ok(book);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer minPages,
            @RequestParam(required = false) Integer maxPages) {

        try {
            List<Book> books;

            if (author != null) {
                books = bookService.findByAuthor(author);
            } else if (language != null) {
                books = bookService.findByLanguage(language);
            } else if (genre != null) {
                books = bookService.findByGenre(genre);
            } else if (minPages != null && maxPages != null) {
                books = bookService.findByPagesBetween(minPages, maxPages);
            } else {
                books = bookService.findAllBooks();
            }

            return ResponseEntity.ok(books);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{isbn}/title")
    public ResponseEntity<String> updateBookTitle(@PathVariable String isbn,
                                                  @RequestBody UpdateBookDTO updateBookDTO) {
        try {
            bookService.updateBookTitle(isbn, updateBookDTO.getTitle());
            return ResponseEntity.ok("Título actualizado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{isbn}/language")
    public ResponseEntity<String> updateBookLanguage(@PathVariable String isbn,
                                                     @RequestBody UpdateBookDTO updateBookDTO) {
        try {
            bookService.updateBookLanguage(isbn, updateBookDTO.getLanguage());
            return ResponseEntity.ok("Idioma actualizado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable String isbn) {
        try {
            bookService.deleteBook(isbn);
            return ResponseEntity.ok("Libro eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
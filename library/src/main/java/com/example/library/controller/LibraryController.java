package com.example.library.controller;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

// Author endpoints

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author) {
        return libraryService.addAuthor(author);
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails) {
        return libraryService.updateAuthor(id, authorDetails);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        libraryService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return libraryService.getAuthor(id);
    }

    @GetMapping("/authors/{id}/with-books")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable Long id) {
        List<Book> books = libraryService.getBooksByAuthor(id);
        return ResponseEntity.ok(books);
    }

// Book endpoints

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return libraryService.updateBook(id, bookDetails);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        libraryService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Long id) {
        return libraryService.getBook(id);
    }

    // Endpoint zwracający książkę z autorem (w przypadku gdy jest to wymagane)
    @GetMapping("/books/{id}/with-author")
    public ResponseEntity<Book> getBookWithAuthor(@PathVariable Long id) {
        Book book = libraryService.getBook(id);
        return ResponseEntity.ok(book);
    }
}
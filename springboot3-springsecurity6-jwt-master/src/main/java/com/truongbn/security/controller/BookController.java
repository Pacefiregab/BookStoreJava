package com.truongbn.security.controller;

import com.truongbn.security.entities.Book;
import com.truongbn.security.service.BookService;
import com.truongbn.security.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    public BookController(BookServiceImpl bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> listBooks() {
        ArrayList<Book> books = bookService.listBooks();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/{book_id}")
    public ResponseEntity<Book> bookDetails(@PathVariable Long book_id) {
        Book book = bookService.fetchBook(book_id);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/")
    public ResponseEntity<List<Book>> createBook(@RequestParam Book book) {
        Book newBook = bookService.createBook(book);
        return ResponseEntity.created(URI.create("/" + newBook.getId())).build();
    }

    @DeleteMapping("/{book_id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long book_id) {
        bookService.deleteBook(book_id);
        return ResponseEntity.noContent().build();
    }

}

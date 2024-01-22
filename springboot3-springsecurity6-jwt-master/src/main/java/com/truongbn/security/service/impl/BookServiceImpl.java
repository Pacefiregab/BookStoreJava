package com.truongbn.security.service.impl;

import com.truongbn.security.entities.Book;
import com.truongbn.security.repository.BookRepository;
import com.truongbn.security.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private BookRepository repository;
    @Override
    public ArrayList<Book> listBooks() {
        ArrayList<Book> books = (ArrayList<Book>) repository.findAll();
        return books;
    }

    @Override
    public Book fetchBook(Long bookId) throws NoSuchElementException{
        Book book = repository.findById(bookId).orElseThrow(NoSuchElementException::new);
        return book;
    }

    @Override
    public Book createBook(Book book) {
        Book newBook = repository.save(book);
        return newBook;
    }

    @Override
    public void deleteBook(Long bookId) {
        repository.delete(fetchBook(bookId));
    }
}

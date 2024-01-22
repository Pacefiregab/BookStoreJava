package com.truongbn.security.service;

import com.truongbn.security.entities.Book;

import java.util.ArrayList;

public interface BookService {
    ArrayList<Book> listBooks();

    Book fetchBook(Long bookId);

    Book createBook(Book book);

    void deleteBook(Long bookId);
}

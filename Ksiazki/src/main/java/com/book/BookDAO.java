package com.book;

import com.book.domain.Book;

import java.util.List;

public interface BookDAO {
    Book addBook(Book book);
    void deleteBook(Book book);
    Book updateBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
}

package com.book.service;

import com.book.BookDAO;
import com.book.domain.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless

public class BookManager implements BookDAO{

    @PersistenceContext
    EntityManager em;

    public Book addBook(Book book) {
        em.persist(book);
        em.flush();

        return book;
    }

    public void deleteBook(Book book) {
        em.remove(em.getReference(Book.class, book.getIdBook()));
    }

    public Book updateBook(Book book) {
        return (Book)em.merge(book);
    }

    public List<Book> getAllBooks() {
        return em.createNamedQuery("book.getAll").getResultList();
    }

    public Book getBookById(Long id) {
        return em.find(Book.class, id);
    }
}

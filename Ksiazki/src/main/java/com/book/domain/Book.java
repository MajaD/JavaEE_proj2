package com.book.domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "book.getAll", query = "Select b from Book b"),
        @NamedQuery(name = "book.getById", query = "Select b from Book b where b.idBook = :idBook")
})

public class Book {
    private Long idBook;
    private String bookTitle;
    private String bookDesc;

    private Category category;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }


    @ManyToOne
    @JoinColumn(name = "idCategory")
    public Category getCategory()
    {
        return category;
    }
    public void setCategory(Category category)
    {
        this.category = category;
    }
}

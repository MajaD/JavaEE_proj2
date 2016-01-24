package com.book.domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = "category.getAll", query = "Select c from Category c"),
        @NamedQuery(name = "category.getById", query = "Select c from Category c where c.idCategory = :idCategory")
})


public class Category {

    private Long idCategory;
    private String categoryName;

    private List<Book> books = new ArrayList<Book>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
    @JsonIgnore
    public List<Book> getBooks() {

        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;

    }
}

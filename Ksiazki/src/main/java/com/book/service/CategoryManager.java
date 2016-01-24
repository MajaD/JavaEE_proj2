package com.book.service;


import com.book.CategoryDAO;
import com.book.domain.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoryManager implements CategoryDAO {

    @PersistenceContext
    EntityManager em;

    public Category addCategory(Category category) {
        em.persist(category);
        em.flush();

        return  category;
    }

    public void deleteCategory(Category category) {
        em.remove(em.getReference(Category.class, category.getIdCategory()));
    }

    public Category updateCategory(Category category) {
        return (Category)em.merge(category);
    }

    public List<Category> getAllCategories() {
        return em.createNamedQuery("category.getAll").getResultList();
    }

    public Category getCategoryById(Long id) {
        return em.find(Category.class, id);
    }
}

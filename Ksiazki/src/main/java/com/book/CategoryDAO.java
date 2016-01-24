package com.book;

import com.book.domain.*;

import java.util.List;

public interface CategoryDAO {
    Category addCategory(Category category);
    void deleteCategory(Category category);
    Category updateCategory(Category category);
    List getAllCategories();
    Category getCategoryById(Long id);

}

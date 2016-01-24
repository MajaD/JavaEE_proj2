package com.book.rest;

import com.book.CategoryDAO;
import com.book.domain.Category;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/category")

public class CategoryResource {

    @EJB
    private CategoryDAO categoryManager;

    @POST
    @Path("/addCategory")
    public Response addCategory(@FormParam("categoryName") String categoryName)
    {
        Category category = new Category();
        category.setCategoryName(categoryName);

        categoryManager.addCategory(category);

        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/updateCategory")
    public Response updateCategory(
            @FormParam("idCategory") Long idCategory,
            @FormParam("categoryName") String categoryName)
    {
        Category category = new Category();
        category.setIdCategory(idCategory);
        category.setCategoryName(categoryName);

        categoryManager.updateCategory(category);

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/deleteCategory")
    public Response deleteCategory(@FormParam("idCategory") long idCategory)
    {
        Category category = new Category();
        category.setIdCategory(idCategory);

        categoryManager.deleteCategory(category);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/getAllCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAllCategories()
    {
        return categoryManager.getAllCategories();
    }

    @GET
    @Path("/getCategory/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryById(@PathParam("id") Long id)
    {
        return categoryManager.getCategoryById(id);
    }

}

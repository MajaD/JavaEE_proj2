package com.book.rest;

import com.book.CategoryDAO;
import com.book.BookDAO;
import com.book.domain.Category;
import com.book.domain.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Stateless
@Path("/book")
public class BookResource {

    @EJB
    private BookDAO bookManger;
    @EJB
    private CategoryDAO categoryManager;

    @POST
    @Path("/addBook")
    public Response addBook(
            @FormParam("bookTitle") String bookTitle,
            @FormParam("category") String category,
            @FormParam("bookDesc") String bookDesc)
    {
        Long categoryId = Long.parseLong(category.substring(0, category.indexOf('.')));

        Book book = new Book();
        book.setBookTitle(bookTitle);
        book.setCategory(categoryManager.getCategoryById(categoryId));
        book.setBookDesc(bookDesc);

        bookManger.addBook(book);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/updateBook")
    public Response updateBook(
            @FormParam("idBook") long idBook,
            @FormParam("bookTitle") String bookTitle,
            @FormParam("category") String category,
            @FormParam("bookDesc") String bookDesc)
    {
        Long categoryId = Long.parseLong(category.substring(0, category.indexOf('.')));

        Book book = new Book();
        Category categoryObj = categoryManager.getCategoryById(categoryId);
        book.setIdBook(idBook);
        book.setBookTitle(bookTitle);
        book.setCategory(categoryObj);
        book.setBookDesc(bookDesc);

        bookManger.updateBook(book);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/deleteBook")
    public Response deleteBook(@FormParam("idBook") long idBook)
    {
        Book book = new Book();
        book.setIdBook(idBook);

        bookManger.deleteBook(book);

        return Response.status(Response.Status.OK).build();
    }


    @GET
    @Path("/getAllBooks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks()
    {
        return  bookManger.getAllBooks();
    }

    @GET
    @Path("/getBook/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookById(@PathParam("id") Long Id)
    {
        return bookManger.getBookById(Id);
    }
}

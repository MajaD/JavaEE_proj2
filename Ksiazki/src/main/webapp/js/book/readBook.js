$(document).ready(function()
{
    var id = window.location.search.replace("?id=", "");

    $.get("/book/rest/book/getBook/" + id, function(data, textStatus)
    {
        document.getElementById('id').innerHTML = data.idBook;
        document.getElementById('bookTitle').innerHTML = data.bookTitle;
        document.getElementById('bookDesc').innerHTML = data.bookDesc;
        document.getElementById('category').innerHTML = data.category.categoryName;
    });
});

$(document).ready(function()
{
    var id = window.location.search.replace("?id=", "");

    document.getElementById('idBook').value = id;

    //Load products
    $.get("/book/rest/category/getAllCategories", function(data, textStatus)
    {
        var categorySelect = document.getElementById('category');

        for(var i in data) {
            var opt = document.createElement('option');

            var categoryInfo = data[i].idCategory + ". " + data[i].categoryName;

            opt.value = categoryInfo;
            opt.innerHTML = categoryInfo;
            categorySelect.appendChild(opt);
        }
    });

    //Load rest of shop order data
    $.get("/book/rest/book/getBook/" + id, function(data, textStatus)
    {

        document.getElementById('id').innerHTML = data.idBook;
        document.getElementById('category').value = data.category.idCategory + ". " + data.category.categoryName;
        document.getElementById('bookTitle').value = data.bookTitle;
        document.getElementById('bookDesc').value = data.bookDesc;
    });
});
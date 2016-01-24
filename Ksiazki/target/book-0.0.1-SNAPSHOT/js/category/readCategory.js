$(document).ready(function()
{
    var id = window.location.search.replace("?id=", "");

    $.get("/book/rest/category/getCategory/" + id, function(data, textStatus)
    {
        document.getElementById('id').innerHTML = data.idCategory;
        document.getElementById('categoryName').innerHTML = data.categoryName;
    });
});

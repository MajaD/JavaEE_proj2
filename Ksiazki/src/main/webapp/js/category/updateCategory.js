$(document).ready(function()
{
    var id = window.location.search.replace("?id=", "");

    document.getElementById('idCategory').value = id;

    $.get("/book/rest/category/getCategory/" + id, function(data, textStatus)
    {
        document.getElementById('id').innerHTML = data.idCategory;
        document.getElementById('categoryName').value = data.categoryName;
    });
});
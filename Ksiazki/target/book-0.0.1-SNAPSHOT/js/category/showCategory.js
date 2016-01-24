$(document).ready(function()
{
    $.get("/book/rest/category/getAllCategories", function(data, textStatus)
    {
        var table = document.getElementById('presentationTable');

        for(var i in data)
        {

            var row = document.createElement("tr");

            var cellId = document.createElement("td");
            var cellIdText = document.createTextNode(data[i].idCategory);

            var cellCategory = document.createElement("td");
            var cellCategoryText = document.createTextNode(data[i].categoryName);

            cellId.appendChild(cellIdText);
            cellCategory.appendChild(cellCategoryText);

            var cellRead = document.createElement("td");
            var cellReadLink = document.createElement("a");

            cellReadLink.href = "../../book/operations/category/readCategory.html?id=" + data[i].idCategory;
            cellReadLink.textContent = "Read";
            cellRead.appendChild(cellReadLink);

            var cellUpdate = document.createElement("td");
            var cellUpdateLink = document.createElement("a");

            cellUpdateLink.href = "../../book/operations/category/updateCategory.html?id=" + data[i].idCategory;
            cellUpdateLink.textContent = "Update";
            cellUpdate.appendChild(cellUpdateLink);

            var cellDelete = document.createElement("td");
            var cellDeleteLink = document.createElement("a");

            cellDeleteLink.href = "../../book/operations/category/deleteCategory.html?id=" + data[i].idCategory;
            cellDeleteLink.textContent = "Delete";
            cellDelete.appendChild(cellDeleteLink);

            row.appendChild(cellId);
            row.appendChild(cellCategory);
            row.appendChild(cellRead);
            row.appendChild(cellUpdate);
            row.appendChild(cellDelete);

            table.appendChild(row);
        }
    });
});
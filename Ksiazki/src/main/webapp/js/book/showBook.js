$(document).ready(function()
{
    $.get("/book/rest/book/getAllBooks", function(data, textStatus)
    {
        var table = document.getElementById('presentationTable');

        for(var i in data)
        {
            var row = document.createElement("tr");

            var cellId = document.createElement("td");
            var cellIdText = document.createTextNode(data[i].idBook);

            var cellCategory = document.createElement("td");
            var cellCategoryText = document.createTextNode(data[i].category.categoryName);

            var cellTitle = document.createElement("td");
            var cellTitleText = document.createTextNode(data[i].bookTitle);

            var cellDesc = document.createElement("td");
            var cellDescText = document.createTextNode(data[i].bookDesc);

            cellId.appendChild(cellIdText);
            cellCategory.appendChild(cellCategoryText);
            cellTitle.appendChild(cellTitleText);
            cellDesc.appendChild(cellDescText);

            var cellRead = document.createElement("td");
            var cellReadLink = document.createElement("a");

            cellReadLink.href = "../../book/operations/book/readBook.html?id=" + data[i].idBook;
            cellReadLink.textContent = "Read";
            cellRead.appendChild(cellReadLink);

            var cellUpdate = document.createElement("td");
            var cellUpdateLink = document.createElement("a");

            cellUpdateLink.href = "../../book/operations/book/updateBook.html?id=" + data[i].idBook;
            cellUpdateLink.textContent = "Update";
            cellUpdate.appendChild(cellUpdateLink);

            var cellDelete = document.createElement("td");
            var cellDeleteLink = document.createElement("a");

            cellDeleteLink.href = "../../book/operations/book/deleteBook.html?id=" + data[i].idBook;
            cellDeleteLink.textContent = "Delete";
            cellDelete.appendChild(cellDeleteLink);

            row.appendChild(cellId);
            row.appendChild(cellCategory);
            row.appendChild(cellTitle);
            row.appendChild(cellDesc);
            row.appendChild(cellRead);
            row.appendChild(cellUpdate);
            row.appendChild(cellDelete);

            table.appendChild(row);
        }
    });
});
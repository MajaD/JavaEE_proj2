$(document).ready(function() {

    //Load products
    $.get("/book/rest/category/getAllCategories", function (data, textStatus) {
        var productSelect = document.getElementById('categoryId');

        for (var i in data) {
            var opt = document.createElement('option');

            var categoryInfo = data[i].idCategory + ". " + data[i].categoryName;

            opt.value = categoryInfo;
            opt.innerHTML = categoryInfo;
            productSelect.appendChild(opt);
        }
    });
});
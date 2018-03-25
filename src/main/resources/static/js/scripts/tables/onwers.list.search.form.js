$(document).ready(function () {
    $("div.search-form-header").click(function () {
        var header = $(this);
        var content = header.next();
        content.slideToggle(500, function () {
            header.text(function () {
                return content.is(':visible') ? 'EXPEND SEARCH FORM' : 'COLLAPSE SEARCH FORM';
            });
        });

    });
});

function requestContext() {
    var contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
    if (contextPath == null) {
        contextPath = "/";
    }
    return (window.location.protocol + "//" + window.location.host + contextPath)
};

function getUrlParam(name) {
    var results = new RegExp('[\?&]' + name + '=([^]*)').exec(window.location.href);
    if (results == null) {
        return null;
    }
    else {
        return decodeURIComponent(results[1]) || 0;
    }
};

function convertToTimestamp(dateFromPicker) {
    var splittedDate = dateFromPicker.split(/[-: ]/);
    var splittedSecond = splittedDate[5].split('.');
    var date = new Date(splittedDate[0], splittedDate[1]-1, splittedDate[2], splittedDate[3], splittedDate[4], splittedSecond[0], splittedSecond[1]);
    return  date.getTime();
};

function expandFilterMenu(selectors) {
    $(selectors).click(function () {
        var fieldset = $(this).parent();
        var isWrappedInDiv = $(fieldset.children()[0]).is('div');

        if (isWrappedInDiv) {
            fieldset.find("div").slideToggle();
        } else {
            fieldset.wrapInner("<div>");
            $(this).appendTo($(this).parent().parent());
            fieldset.find("div").slideToggle();
        }
    });
};


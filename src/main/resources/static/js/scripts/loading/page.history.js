$.cergis = $.cergis || {};
$.cergis.loadContent = function () {
    $('.ajax-loader').show();
// Perform an asynchronous HTTP (Ajax) request using JQuery to get the content we need to display
    $.ajax({
               url: pageUrl + '?type=ajax', success: function (data) {
            $('#cixp-main-layout').html(data);
            // hide ajax loader
            $('.ajax-loader').hide();
        }
           });
    // Change the URL to the one the user has clicked.
    if (pageUrl != window.location) {
        window.history.pushState({path: pageUrl}, '', pageUrl);
    }
};

// Override the browser back and forward buttons so that we can navigate back and forward without refreshing the page.
$.cergis.backForwardButtons = function () {
    $(window).on('popstate', function () {
        $.ajax({
                   url: location.pathname + '?type=ajax',
                   success: function (data) {
                       $('#cixp-main-layout').html(data);
                   }
               });
    });
};

// Get the value of the href attribute of the menu item the user has clicked.
$("a").on('click', function (event) {
    pageUrl = $(this).attr('href');
    $.cergis.loadContent();
    event.preventDefault();
});

$.cergis.backForwardButtons();
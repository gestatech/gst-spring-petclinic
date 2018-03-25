(function($) {
    var $root = $('#notifications-spacer');
    var notifications = {
        init: function() {
            $root.on('notify', function(e) {

                // This is just an example for notification alerts...
                $('<div class="alert alert-success">' + e.message + '</div>')
                    .prependTo('#notifications-spacer')
                    .hide()
                    .slideDown()
                    .delay(2000)
                    .slideUp(function() {
                        $(this).remove();
                    });
            });
        }
    };

    var sampleModule = {
        init: function() {

            $('form').on('submit', function() {
                var txt = $('#message').val() || 'Please enter some Text';

                // Trigger a Notification
                $app.trigger({
                    type: 'notify',
                    message: txt
                });

                return false;
            });
        }
    };

    notifications.init();
    sampleModule.init();
})(jQuery);
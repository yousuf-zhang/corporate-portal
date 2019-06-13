(function (window) {
    "use strict";
    var App = window.App || {};
    var $ = window.jQuery;
    function NavBar(navBarsId) {
        $(navBarsId).find("a").removeClass("active");
        $(navBarsId).find("a").each(function () {
            if ($(this).prop("href") === window.location.href ) {
                $(this).addClass("active");
            }
        });
    }
    App.NavBar = NavBar;
    window.App = App;
})(window);
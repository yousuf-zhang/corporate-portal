(function (window) {
    "use strict";
    var App = window.App || {};
    var $ = window.jQuery;

    function Pagination(pageId) {
        this.$form = $('#'+pageId).parent('form');
        this.init();
    }
    Pagination.prototype = {
        init: function () {
            this.previous();
            this.next();
            this.goto();
        },
        previous: function () {
            var $form = this.$form;
            this.$form.find('a[data-name="previous"]').click(function (event) {
                event.preventDefault();
                var $page = $form.find(":hidden[name='page']");
                $page.val(Number($page.val()) - 1);
                $form.submit();
            });
        },
        next: function () {
            var $form = this.$form;
            this.$form.find('a[data-name="next"]').click(function (event) {
                event.preventDefault();
                var $page = $form.find(":hidden[name='page']");
                $page.val(Number($page.val())+1);
                $form.submit();
            });
        },
        goto: function () {
            var $form = this.$form;
            this.$form.find('a[data-name="page"]').click(function (event) {
                event.preventDefault();
                var $page = $form.find(":hidden[name='page']");
                $page.val($(this).attr("data-value"));
                $form.submit();
            });
        }

    };

    App.Pagination = Pagination;
    window.App = App;

})(window);
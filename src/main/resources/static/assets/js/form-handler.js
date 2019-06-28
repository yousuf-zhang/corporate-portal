(function (window) {
    "use strict";
    var App = window.App || {};
    var $ = window.jQuery;

    function FormHandler(selector, ueditorId) {
        this.$formElement = $(selector);
        this.ueditorId = ueditorId;
    }

    FormHandler.prototype.addSubmitHandler = function () {

        var $form = this.$formElement;
        this.$formElement.on('submit', function (event) {
            event.preventDefault();
            var data = $(this).serializeArray();
            console.log();
            App.Ueditor.addError("content","内容不能为空");
            console.log(data);
            //ueditor.removeError();
            console.log($("#content").attr("class"));

        });
    };

    FormHandler.prototype.addInputHandler = function() {
        this.$formElement.on("input", function (event) {
            console.log(event.target.value);
        });
    };
    App.FormHandler = FormHandler;
    window.App = App;
})(window);
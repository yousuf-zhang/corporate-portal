(function (window) {
    "use strict";
    var App = window.App || {};
    var $ = window.jQuery;

    function getContent(id) {
        return $("#" + id);
    }

    function getError(id) {
        var $error = $("#" + id +"_ueditor_error");
        if ($error.length === 0) {
            $error = $("<div class='text-danger'></div>").attr("id", id+"_ueditor_error");
        }
        return $error;
    }

    App.Ueditor = {
        getEditor: function (id, opt) {
            var _opt = opt || {};
            return UE.getEditor(id, _opt);
        },
        addError: function (id, message) {
            var $content = getContent(id);
            $content.children("div:first-child").addClass("border-danger").removeClass("border-success");
            var $error = getError(id);
            $content.append($error.html(message));
        },
        removeError: function (id) {
            getError(id).remove();
            getContent(id).children("div:first-child").addClass("border-success").removeClass("border-danger");
        }
    };
    window.App = App;
})(window);
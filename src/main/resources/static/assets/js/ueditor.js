(function (window) {
    "use strict";
    var App = window.App || {};
    var $ = window.jQuery;

    function Ueditor(id) {
        this.ue = UE.getEditor(id);
    }
    App.Ueditor = Ueditor;
    window.App = App;
})(window);
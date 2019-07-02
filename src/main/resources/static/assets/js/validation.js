(function ($) {
    "use strict";
    var ueFlag = "data-ueditor";
    function Validation(form, options) {
        this.form = form;
        this.init(options);

    }

    Validation.prototype = {
        init: function(options) {
            options.rules = options.rules || {};
            options.messages = options.messages || {};
            options.methods = $.extend({}, options.methods, this.methods);
            this.options = options;
            this.options.errors = [];
            this.valid(options);
            var validation = this;
            var $submitBtn = $(this.form).find(":submit");
            $(this.form).submit(function () {
                $submitBtn.prop("disabled", true);
                try {
                    $.each(validation.elements(), function (index, element) {
                        valid(element, options);
                    });
                    console.log(options.errors);
                    if (options.errors.length !== 0) {
                        $submitBtn.prop("disabled", false);
                        return false;
                    }

                    if (options.submitHandler && !options.submitHandler()) {
                        $submitBtn.prop("disabled", false);
                        return false;
                    }
                    return true;

                } catch (e) {
                    console.error(e);
                    return false;
                }
            });

            $(this.form).find(".cancel").click(function () {
                window.history.back();
            });
        },
        valid: function (options) {
            $.each(this.elements(), function (index, element) {
                if (this.ueditor) {
                    this.ueditor.addListener("blur", function () {
                        valid(element, options);
                    });
                    this.ueditor.addListener("contentchange", debounce(function () {
                        valid(element, options);
                    },300));
                } else {
                    $(element).on("input", debounce(function () {
                        valid(element, options);
                    }, 300));
                    $(element).on("blur", function () {
                        valid(element, options);
                    })
                }

            })
        },

        methods: {
            required: function (value, element) {
                return !element.getValue();
            },
            maxLength: function (value, element) {
                return getLength(element) > value;
            },
            number: function(value, element) {
                var regexp = "^\\d+$";
                return regExp(regexp, element);
            },
            regExp: function (value, element) {
                return regExp(value, element);
            }
        },
        elements: function () {
            return $(this.form).find("input, select, textarea")
                .not(":submit, :reset, :image, :disabled")
                .filter(function () {
                    var validator = this;
                    validator.name = this.name || $(this).attr( "name" );
                    if ($(this).attr(ueFlag)) {
                        validator.ueditor = App.Ueditor.getEditor($(this).attr(ueFlag));
                        validator.getValue = function () {
                            return validator.ueditor.getContent();
                        }
                    } else {
                        validator.getValue = function () {
                            return $.trim($(this).val());
                        }
                    }
                    return true;
                });
        }
    };

    function valid(element, options) {
        var flag = false;
        var messages = options.messages[element.name];
        $.each(options.rules[element.name], function (name, value) {
            var validate = options.methods[name];
            if (typeof validate !== "function" ) return;
            flag = validate(value, element);
            if (flag) {

                if(options.errors.filter(function (value) {
                    return value.name === element.name;
                }).length === 0) {
                    options.errors.push(element);
                }
                getError(element, messages[name]);
                $(element).removeAttr("data-validate");
                return false;
            }
        });
        if (flag) {
           return false;
        }
        $(element).attr("data-validate", true);
        getSuccess(element);
        options.errors = options.errors.filter(function (value) {
            return value.name !== element.name;
        });
    }

    function getSuccess(element) {
        if (element.ueditor) {
            App.Ueditor.removeError(element.name);
        } else {
            $(element).addClass("is-valid").removeClass("is-invalid");
        }
    }
    function getError(element, message) {
        if (element.ueditor) {
            App.Ueditor.addError(element.name, message);
        } else {
            var $errorDiv = getErrorElement(element);
            $(element).addClass("is-invalid").removeClass("is-valid");
            $(element).after($errorDiv.html(message));
        }
    }
    function getErrorElement(element) {
        var id = element.name + "_error";
        var $errorDiv = $("#" + id);
        if ($errorDiv.length === 0) {
            $errorDiv = $("<div></div>")
                .attr("id", id)
                .addClass("invalid-feedback");
        }
        return $errorDiv;
    }
    function debounce(fn, delay) {
        // 维护一个 timer
        var timer = null;
        return function() {
            // 通过 ‘this’ 和 ‘arguments’ 获取函数的作用域和变量
            var context = this;
            var args = arguments;
            clearTimeout(timer);
            timer = setTimeout(function() {
                fn.apply(context, args);
            }, delay);

        }
    }

    function getLength(element) {
        switch ( element.nodeName.toLowerCase() ) {
            case "select":
                return $( "option:selected", element ).length;
            case "input":
                return element.getValue().length;
        }
    }

    function regExp(value, element) {
        if (!value) {
            return true;
        }
        return !new RegExp(value).test(element.getValue());
    }
    $.fn.validation = function (options) {
        new Validation(this, options);
    };
})(window.jQuery);
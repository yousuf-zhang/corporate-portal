(function (window) {
    "use strict";
    var App = window.App || {};
    var $ = window.jQuery;
    function Announcement(divId, dataName) {
        this.$div = $("#"+divId);
        this.data = this.$div.data(dataName) || {};
        this.init();

    }
    Announcement.prototype = {
        init: function() {
            this.getInfo();
            this.refresh();
            this.onMouse();
        },
        getInfo: function () {
            var info = this;
            var $div = info.$div;
            if (!info.data.url) return;
            $.ajax(info.data.url,{
                type : "GET",
                data: {size: info.data.size, page: info.data.page},
                success: function (result) {
                    var pagination = result.pagination;
                   if (pagination) {
                       info.data.page = pagination.number;
                       info.data.last = pagination.last;
                   }

                   $.each(result.data, function () {
                       var $li = $('<li class="list-item"></li>');
                       var $a = $("<a></a>'");
                       $a.attr('href', info.data['detail-url'] +'?id=' +  this.id);
                       // $a.attr("target", "_blank");
                       var day = new Date().getTime() - new Date(this.modifyAt).getTime();
                       day = Math.floor(day/86400000);
                       var html =this.title;
                       if (day < 3) {
                           html +=  '&nbsp;<i class="fas fa-bullhorn text-danger"></i>';
                       }
                       $a.html(html);
                       $li.append($a);
                       $div.append($li);
                   })
                }
            })

        },
        refresh: function () {
            var info = this;
            $("#" + info.data["refresh-id"]).click(function (event) {
                event.preventDefault();
                if (info.data.last === false) {
                    info.data.page += 1;
                    info.$div.empty();
                    info.getInfo();
                }
            })
        },
        onMouse: function () {
            var refresh = this;
            $(refresh).parent().hover(function () {
                $(refresh).removeClass("text-secondary").addClass("text-primary");
            }, function () {

                $(refresh).removeClass("text-primary").addClass("text-secondary");
            })
        }

    };
    App.Announcement = Announcement;

    window.App = App;
})(window);
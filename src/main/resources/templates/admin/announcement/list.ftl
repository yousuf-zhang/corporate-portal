<@admin.layout title="通知公告">
  <div class="card">
    <div class="card-header">
    <#list batchButton as button>
      <button type="button" id="${button.methodName}" data-url="${basePath}/${button.url}"
              class="btn btn-outline-primary btn-sm">${button.name}</button>
    </#list>
    </div>
    <div class="card-body">
      <table class="table table-hover">
        <thead class="thead-light">
        <tr>
          <th scope="col">ID</th>
          <th scope="col">标题</th>
          <th scope="col">添加时间</th>
          <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <#list pageData.data as data>
        <tr>
          <th scope="row">${data.id}</th>
          <td>${data.title}</td>
          <td>${data.modifyAt?date('yyyy-MM-dd')}</td>
          <td>@mdo</td>
        </tr>
        </#list>
        </tbody>
      </table>
    </div>
    <div class="card-footer text-right mb-0">
      <form action="${basePath}/admin/announcement/list">
          <@common.pages pageData.pagination 'announcementId'></@common.pages>
      </form>

    </div>
  </div>

</@admin.layout>
<script>
  (function (window) {
    "use strict";
    var App = window.App;
    $("#addAnnouncement").click(function () {
      window.location.href = $(this).attr("data-url");
    });

    new App.Pagination("announcementId");
  })(window);
</script>
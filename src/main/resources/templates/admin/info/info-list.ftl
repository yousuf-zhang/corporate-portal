<@admin.layout title="信息列表">
  <div class="card">
    <div class="card-header">
        <#list batchButton as button>
          <button type="button" onclick="${button.methodName}(this)" data-url="${basePath}/${button.url}"
                  class="btn btn-outline-primary btn-sm">${button.name}</button>
        </#list>
    </div>
    <div class="card-body">
      <table class="table table-hover">
        <thead class="thead-light">
        <tr>
          <th scope="col">ID</th>
          <th scope="col">标题</th>
          <th scope="col">顺序</th>
          <th scope="col">添加时间</th>
          <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <#list pageData.data as data>
          <tr data-id="${data.id}">
            <th scope="row" width="35px">${data.id}</th>
            <td width="40%">${data.title}</td>
            <td width="20%">${data.ordinal!}</td>
            <td width="15%">${data.modifyAt?date('yyyy-MM-dd')?string('yyyy-MM-dd')}</td>
            <td width="25%">
                <#list singleButton as btn>
                  <button type="button" onclick="${btn.methodName}(this)" data-url="${basePath}/${btn.url!}"
                          class="btn btn-outline-primary btn-sm">${btn.name!}</button>
                </#list>
            </td>
          </tr>
        </#list>
        </tbody>
      </table>
    </div>
    <div class="card-footer text-right mb-0">
      <form action="${basePath}/admin/info/list">
          <@common.pages pageData.pagination 'informationId'></@common.pages>
      </form>
    </div>
  </div>
  <script>
  function addInformation(btn) {
      window.location.href = $(btn).attr("data-url");
  }

  function updateInformation(btn) {
      window.location.href=$(btn).attr("data-url")+"?id="+$(btn).parents("tr").attr("data-id");
  }

  function deleteInformation(btn) {
      window.location.href = $(btn).attr("data-url")+"?id=" + $(btn).parents("tr").attr("data-id");
  }
  (function (window) {
      "use strict";
      var App = window.App;

      new App.Pagination("informationId");
  })(window)
  </script>
</@admin.layout>
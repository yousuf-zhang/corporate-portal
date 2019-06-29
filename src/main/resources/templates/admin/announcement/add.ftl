<@admin.layout title="新增公告">
  <form action="${basePath}/admin/announcement/add" method="post" id="annForm">
    <div class="form-group row">
      <label for="title" class="col-sm-2 col-form-label col-form-label-sm text-right">标题:</label>
      <div class="col-sm-8">
        <input type="text" name="title" class="form-control form-control-sm" id="title"
               placeholder="填写标题">
      </div>
    </div>
    <div class="form-group row">
      <label for="content" class="col-sm-2 col-form-label col-form-label-sm text-right">内容:</label>
      <div class="col-sm-8">
        <textarea id="content" name="content" data-ueditor="content"></textarea>
      </div>
    </div>
    <div class="form-group row justify-content-end">
      <div class="col-sm-1"><button  id="btn" type="submit" class="btn btn-primary btn-sm btn-block">提交</button></div>
      <div class="col-sm-1"><button type="button" class="btn btn-secondary btn-sm btn-block cancel">返回</button></div>
      <div class="col-sm-2"></div>
    </div>
  </form>
  <script>
    (function (window) {
      var App = window.App;
      App.Ueditor.getEditor("content", {initialFrameHeight: 300});

      $("#annForm").validation({
        rules: {
          title: {
            required: true,
            maxLength: 200
          },
          content: {
            required: true
          }
        },
        messages: {
          title: {
            required: '请填写标题信息',
            maxLength:'最多长度为200'
          },
          content: {
            required: '公告内容不能为空'
          }
        }

      });
    })(window)
  </script>
</@admin.layout>

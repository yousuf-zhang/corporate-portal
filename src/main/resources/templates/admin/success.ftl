<@admin.layout title="成功">
  <div class="row">
    <div class="col-sm-8 m-auto">
      <div class="card text-center">
        <div class="card-body">
          <span><i class="far fa-check-circle text-success fa-5x"></i></span>
          <h5 class="card-title mt-2">${content}</h5>
          <a href="${basePath}/${url}" class="btn btn-primary
          active" role="button" aria-pressed="true"><span class="pl-3 pr-3">确定</span></a>
        </div>
      </div>
    </div>

  </div>
</@admin.layout>
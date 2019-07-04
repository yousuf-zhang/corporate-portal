<#macro detail title="">
    <@catalog.layout title="${title}">
      <div class="row pt-3">
        <div class="col-sm-8" >
            <#nested >
        </div>
        <div class="col-sm-4">
          <#if informationList??>
            <div class="card pb-2 mb-2">
              <div class="card-body">
                <h5 class="card-title">信息公开</h5>
                <div>
                    <#list informationList as info>
                      <button type="button" class="btn btn-block btn-outline-secondary <#if info.id == information.id>active</#if>"
                              onclick="window.location.href='${basePath}/information?id=${info.id}'">
                          ${info.title}
                      </button>
                    </#list>
                </div>
              </div>
            </div>
          </#if>
          <@common.card title="档案期刊" class="mb-2">
            <div class="row pb-2">
              <div class="col-sm-4">
                <a href="#">
                  <img class="img-thumbnail" style="height: 100px;" src="${basePath}/assets/images/periodical/20164990656.jpg">
                </a>
              </div>
              <div class="col-sm-4">
                <a href="#">
                  <img class="img-thumbnail" style="height: 100px;" src="${basePath}/assets/images/periodical/20164991311.jpg">
                </a>

              </div>
              <div class="col-sm-4">
                <a href="#">
                  <img class="img-thumbnail" style="height: 100px;" src="${basePath}/assets/images/periodical/201641291924.jpg">
                </a>
              </div>
            </div>
            <div class="row pb-2">
              <div class="col-sm-4 list-item"><a href="#">投稿须知</a></div>
              <div class="col-sm-4 list-item"><a href="#">投稿系统</a></div>
              <div class="col-sm-4 list-item"><a href="#">自由来搞</a></div>
            </div>
            <div class="row pb-2">
              <div class="col-sm-4 list-item"><a href="#">联系方式</a></div>
              <div class="col-sm-4 list-item"><a href="#">电子期刊</a></div>
            </div>
          </@common.card>
          <@common.card title="申请入会" class="mb-2">
            <button type="button" class="btn btn-danger btn-lg btn-block" style="height: 60px;">
              会员登记制度
            </button>
            <button type="button" class="btn btn-success btn-lg btn-block" style="height: 60px;">
              表格下载
            </button>
            <button type="button" class="btn btn-info btn-lg btn-block" style="height: 60px;">
              申请入会
            </button>
          </@common.card>
          <@common.card title="职称评定" class="mb-2">
            <img class="img-fluid pb-2" style="width: 100%" src="${basePath}/assets/images/img_zc.jpg">
            <div class="row  pb-2">
              <div class="col-sm-6">
                <button type="button" class="btn btn-secondary btn-lg btn-block btn-height-30">
                  <span style="font-size: 14px;">政策法规</span>
                </button>
              </div>
              <div class="col-sm-6">
                <button type="button" class="btn btn-secondary btn-lg btn-block btn-height-30">
                  <span style="font-size: 14px;">办事流程</span>
                </button>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <button type="button" class="btn btn-secondary btn-lg btn-block btn-height-30">
                  <span style="font-size: 14px;">表格下载</span>
                </button>
              </div>
              <div class="col-sm-6">
                <button type="button" class="btn btn-secondary btn-lg btn-block btn-height-30">
                  <span style="font-size: 14px;">联系方式</span>
                </button>
              </div>
            </div>
          </@common.card>
          <@common.card title="会员风采">
          </@common.card>
        </div>
      </div>
    </@catalog.layout>
</#macro>
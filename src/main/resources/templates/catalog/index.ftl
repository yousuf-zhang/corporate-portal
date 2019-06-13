<@catalog.layout title="首页">
  <div class="row mt-2">
    <div class="col-sm-6 pr-0">
      <@common.card "", "border-light carousel-height", "m-0 p-0">
        <@common.carousel "index_carousel", carousel, "carousel-height"></@common.carousel>
      </@common.card>
    </div>
    <div class="col-sm-6">
      <@common.card "测试", "carousel-height", "">
      </@common.card>
    </div>
  </div>

  <div class="row mt-2">
    <div class="col-sm-8 pr-0">
      <@common.card "信息公开" "", "">
        <@common.list information ></@common.list>
      </@common.card>
    </div>
    <div class="col-sm-4">
      <@common.card "档案期刊" "", "">
        <div class="row pb-2">
          <div class="col-sm-4">
            <a href="#">
              <img class="img-thumbnail" style="height: 100px;" src="${basePath}/assets/images/periodical/20164990656
              .jpg">
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
    </div>
  </div>

  <div class="row mt-2">
    <div class="col-sm-8 pr-0">
      <@common.card "学会动态" "", "">
        <@common.list information ></@common.list>
      </@common.card>
    </div>
    <div class="col-sm-4">
      <@common.card "申请入会" "", "">
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
    </div>
  </div>

  <div class="row mt-2">
    <div class="col-sm-8 pr-0">
      <@common.card "岗位培训" "", "">
        <div class="text-color">
          <img src="${basePath}/assets/images/img_px.jpg" class="w-100 p-0 m-0 mb-2 img-fluid" >
          名称：深圳市档案信息管理培训中心中心办学范围：档案、英语、文秘、经济管理、行政法规培训学校类型：成人非学历教育主管业务部门：
          深圳市教育局发证机关：深圳市教育局中心简介 深圳市档案信息管理培训中心于2001年经由市教育行政管理部门审批正式成立。深...
        </div>
      </@common.card>
    </div>
    <div class="col-sm-4">
      <@common.card "职称评定" "", "">
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
    </div>
  </div>

  <div class="row mt-2">
    <div class="col-sm-8 pr-0">
      <@common.card "继续教育" "", "">
        <@common.list information ></@common.list>
      </@common.card>
    </div>
    <div class="col-sm-4">
      <@common.card "会员风采" "", "">
      </@common.card>
    </div>
  </div>
  <div class="row mt-2">
    <div class="col-sm-6 pr-0">
      <@common.card "中介备案" "", "">
        <img src="${basePath}/assets/images/intermediary.jpg" class="w-100 p-0 m-0 mb-2" >
        <div class="row ">
          <div class="col-sm-3 ">
            <button type="button" class="btn btn-secondary btn-lg btn-block btn-height-80">
              <span style="font-size: 14px;">法律法规</span>
            </button>
          </div>
          <div class="col-sm-3">
            <button type="button" class="btn btn-secondary btn-lg btn-block btn-height-80">
              <span style="font-size: 14px;">办事流程</span>
            </button>
          </div>
          <div class="col-sm-3">
            <button type="button" class="btn btn-secondary btn-lg btn-block btn-height-80">
              <span style="font-size: 14px;">表格下载</span>
            </button>
          </div>
          <div class="col-sm-3">
            <button type="button" class="btn btn-secondary btn-lg btn-block btn-height-80">
              <span style="font-size: 14px;">备案结果</span>
            </button>
          </div>
        </div>
      </@common.card>
    </div>
    <div class="col-sm-6">
      <@common.card "档案装备" "", "">

      </@common.card>
    </div>
  </div>
</@catalog.layout>

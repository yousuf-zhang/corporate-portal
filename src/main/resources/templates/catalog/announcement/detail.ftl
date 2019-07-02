<#--
<@catalog.layout title="通知公告">
 <div class="row">
  <div class="col-sm-8">
   <blockquote class="blockquote text-center pt-3">
    <p class="mb-0">${announcement.title}</p>
    <footer class="blockquote-footer">
     <cite>${announcement.modifyAt?date("yyyy-MM-dd")?string("yyyy-MM-dd")}</cite>
     <div class="text-right border-bottom">
      <a href="javascript:window.history.back()" class="text-muted">返回</a>
     </div>
    </footer>
   </blockquote>

   <div class=""> ${announcement.content}</div>

  </div>
  <div class="col-sm-4"></div>
 </div>

</@catalog.layout>-->

<@common.detail title="通知公告">
  <blockquote class="blockquote text-center">
    <p class="mb-0">${announcement.title}</p>
    <footer class="blockquote-footer">
      <cite>${announcement.modifyAt?date("yyyy-MM-dd")?string("yyyy-MM-dd")}</cite>
      <div class="text-right border-bottom">
        <a href="javascript:window.history.back()" class="text-muted">返回</a>
      </div>
    </footer>
  </blockquote>
  <div class=""> ${announcement.content}</div>
</@common.detail>

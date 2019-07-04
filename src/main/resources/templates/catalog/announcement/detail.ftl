<@common.detail title="通知公告">
  <blockquote class="blockquote text-center pb-3 border-bottom">
    <p class="mb-0">${announcement.title}</p>
    <footer class="blockquote-footer">
      <cite>${announcement.modifyAt?date("yyyy-MM-dd")?string("yyyy-MM-dd")}</cite>
    </footer>
  </blockquote>
  <div class="pt-3"> ${announcement.content}</div>
</@common.detail>

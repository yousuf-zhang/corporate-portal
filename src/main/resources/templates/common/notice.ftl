<#if notices??>
  <ul class="list-unstyled">
    <#list notices as notice>
      <li class="list-item"><a href="${notice.url}" >${notice.title}</a></li>
    </#list>
  </ul>
</#if>
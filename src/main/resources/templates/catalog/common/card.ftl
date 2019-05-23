<#macro card title, class, bodyClass>
  <div class="card card-default ${class}">
    <#if title?? && title != ""><div class="card-header">${title}</div></#if>
    <div class="card-body ${bodyClass}">
      <#nested>
    </div>
  </div>
</#macro>
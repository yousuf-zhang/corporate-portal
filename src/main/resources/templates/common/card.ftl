<#macro card title="", refreshId="", class="", bodyClass="">
  <div class="card card-default ${class}">
    <#if title?? && title != "">
      <div class="card-header">
        <div class="row">
          <div class="col-sm-10">${title}</div>
          <#if refreshId !="">
          <div class="col-sm-2 text-right m-auto" id="${refreshId}">
            <a href="#"><i class="fas fa-sync-alt text-secondary"></i>&nbsp;换一换</a>
          </div>
          </#if>

        </div>
      </div>
    </#if>
    <div class="card-body ${bodyClass}">
      <#nested>
    </div>
  </div>
</#macro>
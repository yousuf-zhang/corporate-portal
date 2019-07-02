<#macro detail title="">
    <@catalog.layout title="${title}">
      <div class="row pt-3">
        <div class="col-sm-8" >
            <#nested >
        </div>
        <div class="col-sm-4">
          <#if informationList??>
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">信息公开</h5>
                <div>
                    <#list informationList as info>
                      <button type="button" class="btn btn-block btn-outline-secondary <#if info.id == information
                      .id>active</#if>"
                              onclick="window.location.href='${basePath}/information?id=${info.id}'">
                          ${info.title}
                      </button>
                    </#list>
                </div>
              </div>
            </div>
          </#if>
        </div>
      </div>

    </@catalog.layout>
</#macro>
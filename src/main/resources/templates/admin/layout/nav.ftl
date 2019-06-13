<#if Session["navBars"]??>
  <div class="accordion" id="accordionExample">
  <#list Session["navBars"] as navBar>
    <div class="card">
      <div class="card-header p-0 pl-3" id="${navBar.id}">
        <button class="btn btn-link" type="button" data-toggle="collapse"
                data-target="#collapse-${navBar.id}" aria-expanded="${navBar.expanded?c}"
                aria-controls="collapse-${navBar.id}">
         ${navBar.name}
        </button>
      </div>
      <div id="collapse-${navBar.id}" class="collapse <#if navBar.expanded> show</#if>" aria-labelledby="${navBar.id}"
           data-parent="#accordionExample">
        <div class="card-body p-0">
          <div class="list-group list-group-flush pl-3">
            <#list navBar.children as child>
              <a href="${basePath}/${child.url}" class="list-group-item list-group-item-action">${child.name}</a>
            </#list>
          </div>
        </div>
      </div>
    </div>
  </#list>
  </div>
</#if>

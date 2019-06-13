<#macro carousel id, carousels imgClass>
  <div id="${id}" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <#list carousels as carouse>
      <li data-target="#${id}" data-slide-to="${carouse_index}"
          class="<#if carouse_index = 0>active</#if>"></li>
    </#list>
  </ol>
  <div class="carousel-inner">
    <#list carousels as carouse>
      <div class="carousel-item <#if carouse_index = 0>active</#if>">
        <img class="d-block w-100 ${imgClass}" src="${basePath}/assets/images/${carouse.url}">
        <div class="carousel-caption d-none d-sm-block">
          <p>${carouse.title}</p>
        </div>
      </div>
    </#list>
  </div>
  <a class="carousel-control-prev" href="#${id}" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#${id}" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</#macro>

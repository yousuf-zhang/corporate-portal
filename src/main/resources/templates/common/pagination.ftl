<#macro pages pagination pageId>
  <#if pagination??>
    <nav aria-label="Page navigation example" id="${pageId}">
      <input type="hidden" name="size" value="${pagination.pageRequest.size}">
      <input type="hidden" name="page" value="${pagination.pageRequest.page}">
      <input type="hidden" name="direction" value="${pagination.pageRequest.direction!}">
      <input type="hidden" name="sorts" value="${pagination.pageRequest.sorts!}">
      <ul class="pagination justify-content-end">
        <li class="page-item disabled" >
          <span class="page-link">共<span class="text-danger">&nbsp;${pagination.total }&nbsp;</span>条记录</span>
        </li>
        <li class="page-item <#if pagination.first>disabled</#if>">
          <a class="page-link"  href="#" aria-label="Previous" data-name="previous">
            <span aria-hidden="true">&laquo;</span>
            <span class="sr-only">Previous</span>
          </a>
        </li>
        <#list pagination.pages as page>
          <#if page != -99>
            <li class="page-item <#if page == pagination.number>active</#if>">
              <a class="page-link" href="#" data-name="page" data-value="${page}">${page}
                <#if page == pagination.number><span class="sr-only">(current)</span></#if>
              </a>
            </li>
          </#if>
          <#if page == -99>
            <li class="page-item disabled">
              <span class='page-link'>•••</span>
            </li>
          </#if>
        </#list>
        <li class="page-item  <#if pagination.last>disabled</#if>">
          <a class="page-link" href="#" aria-label="Next" data-name="next">
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Next</span>
          </a>
        </li>
      </ul>
    </nav>
  </#if>
</#macro>

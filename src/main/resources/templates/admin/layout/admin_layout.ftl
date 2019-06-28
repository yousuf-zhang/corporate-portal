<!DOCTYPE html>
<#macro layout title>
<html lang="en">
<head>
  <base id="ctx" href="${basePath}">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link href="${basePath}/assets/css/main.css" rel="stylesheet" type="text/css">
  <link href="${basePath}/assets/css/font-awesome/css/all.min.css" rel="stylesheet" type="text/css">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
          integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
  </script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
          integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
  </script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
          integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
  </script>
  <script type="text/javascript" charset="utf-8" src="${basePath}/ueditor/ueditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="${basePath}/ueditor/ueditor.all.js"> </script>
  <script type="text/javascript" charset="utf-8" src="${basePath}/ueditor/lang/zh-cn/zh-cn.js"></script>
  <script src="${basePath}/assets/css/font-awesome/js/all.min.js"></script>
  <script src="${basePath}/assets/js/ueditor.js"></script>
  <script src="${basePath}/assets/js/main.js"></script>
  <script src="${basePath}/assets/js/validation.js"></script>
  <script src="${basePath}/assets/js/pagination.js"></script>
  <title><#if title?? >${title}|</#if>深圳市档案学会 Society of Shenzhen Archives</title>
</head>
<body class="bg-light">
<#include "header.ftl">
<main role="main" class="container-fluid p-0" >
  <div class="row min-vh-100" >
    <div class="col-md-3 bg-light p-0">
        <#include "nav.ftl">
    </div>
    <div class="col-md-9">
      <div class="row">
        <div class="col-md-11">
          <#if breadcrumbs??>
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <#list breadcrumbs as breadcurmb>
                  <li class="breadcrumb-item active" <#if !breadcurmb_has_next>aria-current="page"</#if>
                  >${breadcurmb.name}</li>
                </#list>
              </ol>
            </nav>
          </#if>
        </div>
      </div>
      <div class="row">
        <div class="col-md-11">
            <#nested >
        </div>
      </div>

    </div>
  </div>

</main>
</body>
</html>
</#macro>
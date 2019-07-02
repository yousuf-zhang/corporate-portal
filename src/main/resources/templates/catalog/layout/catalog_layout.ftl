<!DOCTYPE html>
<#macro layout title>
<html lang="en">
<head>
  <base id="ctx" href="${basePath}">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link href="${basePath}/assets/css/font-awesome/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="${basePath}/assets/css/main.css" rel="stylesheet" type="text/css">
  <title><#if title?? >${title}|</#if>深圳市档案学会 Society of Shenzhen Archives</title>
</head>
<body class="bg-light">
<#include "header.ftl">
<main role="main" class="container min-vh-100 p-0">
  <#nested >
</main>

<#include "footer.ftl">
</body>
<script src="${basePath}/assets/jquery/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
  integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
</script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
  integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
</script>
<script src="${basePath}/assets/css/font-awesome/js/all.min.js"></script>
<script src="${basePath}/assets/js/announcement.js"></script>
<script src="${basePath}/assets/js/catalog-main.js"></script>
</html>
</#macro>
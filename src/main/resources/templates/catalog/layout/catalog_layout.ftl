<!DOCTYPE html>
<#global ctx = springMacroRequestContext.contextPath />
<#macro layout title>
<html lang="en">
<head>
  <base id="ctx" href="${ctx}">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="${ctx}/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="${ctx}/assets/main.css" rel="stylesheet" type="text/css">
  <title><#if title?? >${title}|</#if>深圳市档案学会 Society of Shenzhen Archives</title>
</head>
<body>
<#include "header.ftl">
<div >
  <div>
    <#nested >
  </div>

</div>

<#include "footer.ftl">
</body>
<script type="text/javascript" src="${ctx}/assets/bootstrap/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/bootstrap/js/popper.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/bootstrap/js/bootstrap.min.js"></script>
</html>
</#macro>
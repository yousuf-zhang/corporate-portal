<!DOCTYPE html>
<html lang="en">
<head>
  <base id="ctx" href="${basePath}">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link href="${basePath}/assets/css/main.css" rel="stylesheet" type="text/css">
  <title><#if title?? >${title}|</#if>深圳市档案学会 Society of Shenzhen Archives</title>
</head>
<body class="bg-light">
  <div class="row mx-auto">
    <div class="col-md-4">
      <form action="${basePath}/admin/login" method="post">
        用户名：<input name="userName" type="text">
        密码：<input name="password", type="password">
        <button type="submit">登录</button>
      </form>
    </div>
  </div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
</script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
</script>
<script src="${basePath}/assets/js/nav_bar.js"></script>
<script src="${basePath}/assets/js/main.js"></script>
</html>


<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/14/2022
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang nhập thông tin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<h2 style="color: red">Từ điển Cambridge</h2>
<form action="/home/result" method="post">
    <h3>Nhập từ tiếng anh muốn dịch</h3>
    <pre><input name="wordInput" placeholder="Nhập từ tiếng anh"></pre>
    <button type="submit" class="btn btn-primary">Translate</button>
</form>
</body>
</html>

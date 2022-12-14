<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/14/2022
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang tính toán</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<h3>Trang nhập thông tin</h3>
<form method="post" action="/currency-conversion/convert">
<pre>USD:  <input pattern="\d+" name="usd" id="usd" placeholder="Nhập tỉ giá USD"></pre>
    <button type="submit" class="btn btn-primary">Convert</button>
</form>
</body>
</html>

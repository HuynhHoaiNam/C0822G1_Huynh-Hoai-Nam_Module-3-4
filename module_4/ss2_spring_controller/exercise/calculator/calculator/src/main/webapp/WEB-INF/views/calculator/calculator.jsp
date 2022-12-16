<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/15/2022
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang nhập thông tin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>


<body>
<form action="result" method="post" class="container">
    <h1>Calculator</h1><br>
    <input class="form-control" name="firstValue" placeholder="Nhập giá trị 1"></pre><br>
    <select name="operator" class="form-select">
        <option value="+" selected>Cộng</option>
        <option value="-">Trừ</option>
        <option value="*">Nhân</option>
        <option value="/">Chia</option>
    </select><br>
    <input class="form-control" name="secondValue" placeholder="Nhập giá trị 2"></pre>
    <button type="submit" class="btn btn-primary">Tính Toán</button>
</form>
</body>
</html>

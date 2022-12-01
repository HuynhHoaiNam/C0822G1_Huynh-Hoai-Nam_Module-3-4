<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2022
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang tìm kiếm</title>
</head>
<body>
<p><a href="/product">Quay Về Trang Danh Sách</a></p>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>Tên Sản Phẩm</th>
        <th>Giá</th>

    </tr>
    <tr>
        <td>${status.count}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
    </tr>
</table>
</body>
</html>

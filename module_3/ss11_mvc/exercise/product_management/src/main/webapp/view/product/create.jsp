<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2022
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang Thêm Mới</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<h1 style="text-align: center">Trang Thêm Mới Sản Phẩm</h1>
<button class="btn btn-warning"><a href="/product">Quay Về Trang Danh Sách</a></button>
<form action="/product?action=create" method="post">
    <pre>Id Sản Phẩm:     <input type="number" name="id"></pre>
    <pre>Tên Sản Phẩm:    <input type="text" name="name"></pre>
    <pre>Giá Sản Phẩm:    <input type="text" name="price"></pre>
    <pre>Mô Tả Sản Phẩm:  <input type="text" name="describe"></pre>
    <pre>Nhà Sản Xuất:    <input type="text" name="producer"></pre>
    <button type="submit">Lưu</button>
</form>
</body>
</html>

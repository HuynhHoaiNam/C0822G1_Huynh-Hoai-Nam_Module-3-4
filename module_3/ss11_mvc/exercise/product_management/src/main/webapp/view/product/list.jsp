<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2022
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Trang Danh Sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<h1 style="text-align: center">Trang Danh Sách Sản Phẩm</h1>
<button class="btn btn-success btn-sm"><a style="text-decoration: none; color: white" href="/product?action=properties">Thông Tin Chi Tiết</a></button>
<button class="btn btn-success btn-sm"><a style="text-decoration: none; color: white" href="/product?action=create">Thêm Mới Sản Phẩm</a></button>
<form  action="/product?action=search" class="d-flex">
    <input class="form-control me-2"  type="text" placeholder="Tên" aria-label="Search"
           name="nameInput">
    <button class="btn btn-outline-success text-white" type="submit">Search</button>
</form>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>Tên Sản Phẩm</th>
        <th>Giá</th>
        <th>Chức Năng</th>
        <th>Chức Năng</th>
    </tr>
    <c:forEach var="productList" items="${productList}" varStatus="status" >
<tr>
    <td>${status.count}</td>
    <td>${productList.name}</td>
    <td>${productList.price}</td>
    <td><a style="text-decoration: none" href="/product?action=delete&id=${productList.getId()}">Xoá Sản Phẩm</a></td>
    <td><a style="text-decoration: none" href="/product?action=update&id=${productList.getId()}">Sửa Sản Phẩm</a></td>
</tr>
    </c:forEach>
</table>
</body>
</html>

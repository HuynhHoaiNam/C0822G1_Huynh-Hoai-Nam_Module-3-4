<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2022
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Xoá</title>
</head>
<body>
<h1>Trang Xoá Sản Phẩm</h1>
<p><a href="/product">Quay Về Trang Danh Sách</a></p>
<form action="/product?action=delete&id=${requestScope["product"].getId()}" method="post">
    <h3>Bạn có chắc chắn xoá</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Tên:</td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Giá:</td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Mô Tả:</td>
                <td>${requestScope["product"].getDescribe()}</td>
            </tr>
            <tr>
                <td>Nhà Sản Xuất:</td>
                <td>${requestScope["product"].getProducer()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Xoá sản phẩm"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

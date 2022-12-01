<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2022
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <c:if test="${mess!=null}">
        <span style="color: darkred">${mess}</span>
    </c:if>
</head>
<body>
<p><a href="/product">Quay về trang danh sách</a></p>
<form action="/product?action=update&id=${product.getId()}" method="post">
    <fieldset>
        <legend>Thông Tin Sản Phẩm Muốn Chỉnh Sửa</legend>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Describe</th>
                <th>Producer</th>
            </tr>
            <tr>
                <td><input type="text" name="id" value="${product.getId()}"></td>
                <td><input type="text" name="name" value="${product.getName()}"></td>
                <td><input type="text" name="price" value="${product.getPrice()}"></td>
                <td><input type="text" name="describe" value="${product.getDescribe()}"></td>
                <td><input type="text" name="producer" value="${product.getProducer()}"></td>
            </tr>
        </table>
        <button type="submit">Chỉnh Sửa</button>
    </fieldset>
</form>
</body>
</html>

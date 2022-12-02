<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/2/2022
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Trang Chinh Sua</title>
</head>
<body>
<button class="btn btn-warning"><a style="text-decoration: none; color: white" href="/user">Back</a></button>
<form action="/user?action=update&id=${user.getId()}" method="post">
    <fieldset>
        <legend>Thông Tin Người Dùng Muốn Chỉnh Sửa</legend>
        <table>
            <tr>
                <th>Tên</th>
                <th>Email</th>
                <th>Quốc Gia</th>
            </tr>
            <tr>

                <td><input type="text" name="name" value="${user.getName()}"></td>
                <td><input type="text" name="email" value="${user.getEmail()}"></td>
                <td><input type="text" name="country" value="${user.getCountry()}"></td>
            </tr>
        </table>
        <button type="submit">Chỉnh Sửa</button>
    </fieldset>
</form>
<c:if test="${mess!=null}">
    <p>${mess}</p>
</c:if>
</body>
</html>

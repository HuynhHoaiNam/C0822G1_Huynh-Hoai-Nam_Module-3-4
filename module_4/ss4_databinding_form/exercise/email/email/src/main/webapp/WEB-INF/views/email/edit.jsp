<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/16/2022
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Trang Chỉnh Sửa</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>


<form:form method="post" action="/home/edit" modelAttribute="email">
    <table class="table-cell">
        <tr>
            <td><form:hidden path="id"/>
        </tr>
        <tr>
            <td><form:label path="language">Language</form:label></td>
            <td><form:select path="language" items="${languageList}" /></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">PageSize</form:label></td>
            <td><form:select path="pageSize" items="${pageSizeList}" /></td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">SpamsFilter</form:label></td>
            <td><form:checkbox path="spamsFilter"/></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:input path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>

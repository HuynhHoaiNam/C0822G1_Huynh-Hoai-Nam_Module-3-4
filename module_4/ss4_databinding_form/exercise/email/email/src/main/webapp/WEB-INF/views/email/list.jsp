<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/16/2022
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Trang danh sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

</head>
<body>
<c:if test="${mess!=null}">
    <p>${mess}</p>
</c:if>
<table class="table table-info table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Language</th>
        <th scope="col">Page Size</th>
        <th scope="col">Spams Filter</th>
        <th scope="col">Signature</th>
        <th scope="col">Function</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="email" items="${emailList}" varStatus="status">
        <tr>
            <th scope="row">${status.count}</th>
            <td>${email.language}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFilter}</td>
            <td>${email.signature}</td>
            <td>
                <button class="btn btn-primary"><a href="/home/showEdit/${email.id}">Edit</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

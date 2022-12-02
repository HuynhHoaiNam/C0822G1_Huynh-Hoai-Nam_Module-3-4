<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/2/2022
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang Thêm Mới</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<c:if test="${mess!=null}">
    <span style="color: darkgreen">${mess}</span>
</c:if>
<button class="btn btn-warning"><a href="/user" style="color: white">Back</a></button>
<body>
<form action="/user?action=create" method="post">
    <pre>Tên Người dùng:        <input name="name" type="text"></pre>
    <pre>Email Người dùng:      <input name="email" type="text"></pre>
    <pre>Tên Nước:              <input name="country" type="text"></pre>
    <button type="submit">Save</button>
</form>
</body>
</html>

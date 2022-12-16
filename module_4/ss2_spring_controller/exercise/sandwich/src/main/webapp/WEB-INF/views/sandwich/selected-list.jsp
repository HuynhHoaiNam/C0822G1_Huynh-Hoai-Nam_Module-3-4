<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/15/2022
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<pre><h1 style="color: red">Những gia vị bạn đã chọn là: <c:forEach var="nameCheck" items="${nameCheck}">${nameCheck}</c:forEach></h1></pre>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/29/2022
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculator" method="post">
    <pre>Mô tả của sản phẩm:     <input type="text" name="Describe"></pre>
    <pre>Giá Niêm Yết Sản Phẩm:  <input type="text" name="ListPrice"></pre>
    <pre>Giá Chiết Khấu:         <input type="text" name="DiscountPercent"></pre>
    <button type="submit">Kết Quả</button>
  </form>
  </body>
</html>

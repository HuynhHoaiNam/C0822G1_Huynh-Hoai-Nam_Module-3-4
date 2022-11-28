<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/9/2022
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang Thêm Mới Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Thêm Mới Người Dùng</h1>
<c:if test="${mess!=null}">
    <span style="color: green">${mess}</span>
</c:if>
<a href="/furama?action=showCustomer">Quay Lại Trang Danh Sách</a>
<%--<form action="/furama?action=create" method="post">--%>
<%--    <pre>Id:                     <input type="number" name="id"></pre>--%>
<%--    <pre>Id Loại Khách Hàng:     <select name="customerTypeId" >--%>
<%--                                    <c:forEach var="cusType" items="${customerTypeList}">--%>
<%--                                        &lt;%&ndash;value dùng để chuyển đỏi từ mã tên sang mã id&ndash;%&gt;--%>
<%--                                                <option value="${cusType.getIdType()}">--%>
<%--                                                ${cusType.getNameType()}</option>--%>
<%--                                    </c:forEach>--%>
<%--                                </select></pre>--%>
<%--    <pre>Tên:                    <input type="text" name="name" ></pre>--%>
<%--    <pre>Ngày Sinh:              <input type="date" name="dateOfBirth"></pre>--%>
<%--    <pre>Giới Tính:              <input type="radio" name="gender" size="45" value="true" ${customer.isGender()==true?"checked":""} >Nam--%>
<%--                                 <input type="radio" name="gender" size="45" value="false" ${customer.isGender()==false?"checked":""} >Nữ</pre>--%>
<%--    <pre>Số CMND:                <input type="text" name="idCard"></pre>--%>
<%--    <pre>Số ĐT:                  <input type="text" name="phoneNumber"></pre>--%>
<%--    <pre>Email:                  <input type="text" name="email"></pre>--%>
<%--    <pre>Địa Chỉ:                <input type="text" name="address"></pre>--%>
<%--    <pre><button type="submit">Update</button></pre>--%>
<%--</form>--%>

<form action="/furama?action=create" method="post">
        <table class="table table-success table-striped container">
            <tr>
                <th>Id:</th>
                <td><input type="number" name="id"></td>
            </tr>
            <tr>
                <th>Mã Khách Hàng:</th>
                <td><select name="customerTypeId" >
                    <c:forEach var="cusType" items="${customerTypeList}">
                        <%--value dùng để chuyển đỏi từ mã tên sang mã id--%>
                        <option value="${cusType.getIdType()}">
                                ${cusType.getNameType()}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <th>Tên Khách Hàng:</th>
                <td><input type="text" name="name" ></td>
            </tr>
            <tr>
                <th>Ngày Sinh:</th>
                <td><input type="date" name="dateOfBirth"></td>
            </tr>
            <tr>
                <th>Giới Tính:</th>
                <td><input type="radio" name="gender" size="45" value="true" ${customer.isGender()==true?"checked":""} >Nam
                    <input type="radio" name="gender" size="45" value="false" ${customer.isGender()==false?"checked":""} >Nữ
                </td>
            </tr>
            <tr>
                <th>Số cmnd:</th>
                <td><input type="text" name="idCard"></td>
            </tr>
            <tr>
                <th>Số đt:</th>
                <td><input type="text" name="phoneNumber"></td>
            </tr>
            <tr>
                <th>Email:</th>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <th>Địa Chỉ:</th>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <th></th>
                <td><button type="submit"style="background-color: lightskyblue; margin: auto">Update</button></td>
            </tr>
        </table>
</form>
</body>
</html>

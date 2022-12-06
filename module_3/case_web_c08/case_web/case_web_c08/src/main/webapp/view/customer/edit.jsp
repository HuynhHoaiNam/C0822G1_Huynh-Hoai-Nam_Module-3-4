<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/28/2022
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang Chỉnh Sửa Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<h1 style="text-align: center">Chỉnh Sửa Người Dùng</h1>
<c:if test="${mess!=null}">
    <span style="color: green">${mess}</span>
</c:if>
<button class="btn btn-warning"><a class="thea" href="/furama?action=listCustomer">Quay Lại Trang Danh Sách</a></button>
<form action="/furama?action=update&id=${customer.getId()}" method="post">
    <fieldset>
        <table class="table table-success table-striped container">
            <tr>
                <th>Mã Loại Khách:</th>
                <td><select name="customerTypeId">
                    <c:forEach var="cusType" items="${customerTypeList}">
                        <%-- value dùng để chuyển đỏi từ mã tên sang mã id--%>
                        <option value="${cusType.getId()}" ${cusType.getId() == customer.getCustomerTypeId() ? 'selected' : ''}>
                                ${customer.getCustomerType().getName()}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <th>Tên Khách Hàng:</th>
                <td><input type="text" name="name" value="${customer.getName()}"></td>
            </tr>
            <tr>
                <th>Ngày Sinh:</th>
                <td><input type="date" name="dateOfBirth" value="${customer.getDateOfBirth()}"></td>
            </tr>
            <tr>
                <th>Giới Tính:</th>
                <td><input type="radio" name="gender" size="45" value="true" ${customer.isGender()==true?"checked":""} >Nam
                    <input type="radio" name="gender" size="45"
                           value="false" ${customer.isGender()==false?"checked":""} >Nữ
                </td>
            </tr>
            <tr>
                <th>Số cmnd:</th>
                <td><input type="text" name="idCard" value="${customer.getIdCard()}"></td>
            </tr>
            <tr>
                <th>Số đt:</th>
                <td><input type="text" name="phoneNumber" value="${customer.getPhoneNumber()}"></td>
            </tr>
            <tr>
                <th>Email:</th>
                <td><input type="text" name="email" value="${customer.getEmail()}"></td>
            </tr>
            <tr>
                <th>Địa Chỉ:</th>
                <td><input type="text" name="address" value="${customer.getAddress()}"></td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <button type="submit" style="background-color: lightskyblue; margin: auto">Update</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/9/2022
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Trang Tìm Kiếm Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<center>
    <h2>
        <a href="/furama?action=showCustomer">Quay lại danh sách</a>
    </h2>
</center>
<div align="center">
    <div class="col-lg-12" style="text-align: center;background-color: lightyellow"><h1 style="margin: 0">Danh Sách
        Khách Hàng</h1></div>
    <div>
        <td>
            <button class="btn btn-primary"><a href="/furama?action=create" style="color: white; text-decoration: none">Thêm
                Mới</a></button>
        </td>
        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Mã Khách Hàng</th>
                <th scope="col">Tên Khách Hàng</th>
                <th scope="col">Ngày Sinh</th>
                <th scope="col">Giới Tính</th>
                <th scope="col">Số cmnd</th>
                <th scope="col">Số đt</th>
                <th scope="col">Email</th>
                <th scope="col">Địa Chỉ</th>
                <th colspan="3" style="text-align: center">Chức Năng</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <c:forEach var="customer" items="${customerList}" varStatus="status">
            <tr>
                <td scope="row">${status.count}</td>
                    <%--hiển thị mã khách hàng khi search--%>
                <c:forEach var="cusType" items="${customerTypeList}">
                    <c:if test="${cusType.getIdType() == customer.getCustomerTypeId()}">
                        <td>${cusType.getNameType()}</td>
                    </c:if>
                </c:forEach>
                    <%--<td>${customer.getCustomerType().getNameType()}</td>--%>
                <td>${customer.getName()}</td>
                <td>${customer.getDateOfBirth()}</td>
                <td>
                    <label>
                        <c:if test="${customer.isGender()}">
                        Nam</label>
                    <label></c:if>
                        <c:if test="${!customer.isGender()}">
                            Nữ
                        </c:if></label>
                </td>
                <td>${customer.getIdCard()}</td>
                <td>${customer.getPhoneNumber()}</td>
                <td>${customer.getEmail()}</td>
                <td>${customer.getAddress()}</td>
                <td>
                    <button class="btn btn-primary"><a href="/furama?action=update&id=${customer.getId()}"
                                                       style="color: white; text-decoration: none">Sửa</a></button>
                </td>
                <td>
                    <button type="button" onclick="idRemove('${customer.getId()}','${customer.getName()}') "
                            class="btn btn-danger" data-bs-toggle="modal"
                            data-bs-target="#exampleRemove">
                        Xoá
                    </button>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>

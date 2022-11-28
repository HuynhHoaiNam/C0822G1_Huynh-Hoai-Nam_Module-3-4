<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/10/2022
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang CHỉnh Sửa Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <c:if test="${mess!=null}">
        <span style="color: darkred">${mess}</span>
    </c:if>
</head>
<body>
<button><a href="/furama?action=showCustomer" style="text-decoration: none; color: black">Quay về trang danh sách</a></button>
<form action="/furama?action=update&id=${customer.getId()}" method="post">
    <fieldset>
        <legend style="text-align: center">Thông Tin Sản Phẩm Muốn Chỉnh Sửa</legend>
        <table class="table table-success table-striped container">
<%--            <tr>--%>
<%--                &lt;%&ndash;                <th>Id</th>&ndash;%&gt;--%>
<%--                <th>Mã Khách Hàng</th>--%>
<%--                <th>Tên Khách Hàng</th>--%>
<%--                <th>Ngày Sinh</th>--%>
<%--                <th>Giới Tính</th>--%>
<%--                <th>Số cmnd</th>--%>
<%--                <th>Số đt</th>--%>
<%--                <th>Email</th>--%>
<%--                <th>Địa Chỉ</th>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                &lt;%&ndash;                <td><input type="number" name="id" value="${customer.getId()}"></td>&ndash;%&gt;--%>

<%--                <td>--%>
<%--                    &lt;%&ndash;Name trong getParameter trong update(Post) của servlet&ndash;%&gt;--%>
<%--                    <select name="customerTypeId">--%>
<%--                        <c:forEach var="cusType" items="${customerTypeList}">--%>
<%--                            &lt;%&ndash;                            value dùng để chuyển đỏi từ mã tên sang mã id&ndash;%&gt;--%>
<%--                            <option value="${cusType.getIdType()}" ${cusType.getIdType() == customer.getCustomerTypeId() ? 'selected' : ''}>--%>
<%--                                    ${cusType.getNameType()}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </td>--%>

<%--                <td><input type="text" name="name" value="${customer.getName()}"></td>--%>
<%--                <td><label><input type="date" name="dateOfBirth" value="${customer.getDateOfBirth()}"></label></td>--%>
<%--                <td><input type="radio" name="gender" size="45" value="true" ${customer.isGender()==true?"checked":""} >Nam--%>
<%--                    <input type="radio" name="gender" size="45"--%>
<%--                           value="false" ${customer.isGender()==false?"checked":""} >Nữ--%>
<%--                </td>--%>
<%--                <td><input type="text" name="idCard" value="${customer.getIdCard()}"></td>--%>
<%--                <td><input type="text" name="phoneNumber" value="${customer.getPhoneNumber()}"></td>--%>
<%--                <td><input type="text" name="email" value="${customer.getEmail()}"></td>--%>
<%--                <td><input type="text" name="address" value="${customer.getAddress()}"></td>--%>
<%--            </tr>--%>


            <tr>
                <th>Mã Khách Hàng:</th>
                <td><select name="customerTypeId">
                    <c:forEach var="cusType" items="${customerTypeList}">
                        <%--                            value dùng để chuyển đỏi từ mã tên sang mã id--%>
                        <option value="${cusType.getIdType()}" ${cusType.getIdType() == customer.getCustomerTypeId() ? 'selected' : ''}>
                                ${cusType.getNameType()}</option>
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
                <td><button  style="background-color: lightskyblue; margin: auto">Update</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

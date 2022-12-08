<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/5/2022
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Trang Chỉnh Sửa Dịch Vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<c:if test="${mess!=null}">
    <span>${mess}</span>
</c:if>
<form action="/facility?action=update&id=${facilityList.id}" method="post">
    <fieldset>
        <table class="table table-success table-striped container">
            <tr>
                <th>Tên Khách Hàng:</th>
                <td><input type="text" name="name" value="${facilityList.name}"></td>
            </tr>
            <tr>
                <th>Ngày Sinh:</th>
                <td><input type="text" name="area" value="${facilityList.area}"></td>
            </tr>
            <tr>
                <th>Giới Tính:</th>
                <td><input type="radio" name="cost" value="${facilityList.cost}"></td>
            </tr>
            <tr>
                <th>Số cmnd:</th>
                <td><input type="text" name="maxPeople" value="${facilityList.maxPeople}"></td>
            </tr>
            <tr>
                <th>Số cmnd:</th>
                <select name="facilityTypeId">
                    <c:forEach var="facType" items="${facilityTypeList}">
                        <option value="${facType.id}"
                                <c:if test="${facType.id==facilityList.facilityTypeId}">selected</c:if>>${facType.name}</option>
                    </c:forEach>
                </select>
            </tr>
            <tr>
                <th>Số cmnd:</th>
                <td><input type="text" name="rentTypeId" value="${facilityList.rentTypeId}"></td>
            </tr>
            <tr>
                <th>Email:</th>
                <td><input type="text" name="standardRoom" value="${facilityList.standardRoom}"></td>
            </tr>
            <tr>
                <th>Địa Chỉ:</th>
                <td><input type="text" name="descriptionOtherConvenience" value="${facilityList.descriptionOtherConvenience}"></td>
            </tr>
            <tr>
                <th>Địa Chỉ:</th>
                <td><input type="text" name="poolArea" value="${facilityList.poolArea}"></td>
            </tr>
            <tr>
                <th>Địa Chỉ:</th>
                <td><input type="text" name="numberOfFloors" value="${facilityList.numberOfFloors}"></td>
            </tr>
            <tr>
                <th>Địa Chỉ:</th>
                <td><input type="text" name="facilityFree" value="${facilityList.facilityFree}"></td>
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

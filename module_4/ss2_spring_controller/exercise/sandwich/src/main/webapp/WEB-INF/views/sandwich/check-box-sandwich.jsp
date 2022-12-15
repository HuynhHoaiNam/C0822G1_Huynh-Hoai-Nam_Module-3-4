<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/15/2022
  Time: 8:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang lựa chọn gia vị</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<h2 style="color: red">Lựa chọn các loại gia vị mà bạn cần</h2>
<form action="/home/result" method="post">
    <pre><label for="lettuce">Lettuce:</label> <input type="checkbox" name="nameCheck" id="lettuce"
                                                     checked="checked" value="lettuce"></pre>
    <pre> <label for="tomato">Tomato:</label> <input type="checkbox" name="nameCheck" id="tomato" value="tomato"></pre>
    <pre><label for="mustard">Mustard:</label> <input type="checkbox" name="nameCheck" id="mustard" value="mustard"></pre>
    <pre><label for="sprouts">Sprouts:</label> <input type="checkbox" name="nameCheck" id="sprouts" value="sprouts"></pre>
    <pre><label for="sprouts">Sprouts:</label> <input type="checkbox" name="nameCheck" id="soup" value="soup"></pre>
    <button type="submit" class="btn btn-primary">Lưu</button>
</form>
</body>
</html>

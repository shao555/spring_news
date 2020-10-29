<%--
  Created by IntelliJ IDEA.
  User: 15278
  Date: 2020/10/24
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">

        function ba() {
            history.back();
        }

        $(document).ready(function () {
            $("table").attr("bgColor", "#FFFFFF"); //设置表格的背景颜色
            $("tr").attr("bgColor", "#B6B6B6"); //为单数行表格设置背景颜色
            $("tr:even").css("background-color", "#9A9A9A"); //为双数行表格设置背颜色素
            $("table").css("width", "600px")
        }); //为表格添加样式，设置表格长度为300像素
    </script>
</head>
<body>

<table align="center" width="300px" border="1">
    <tr>
        <td>用户姓名</td>
        <td>新闻标题</td>
    </tr>

    <c:forEach items="${tlist}" var="t">
    <tr>
        <td>${u.userName}</td>
<%--        <td>${u.userID}</td>--%>

            <td>${t.topTitle}</td>

    </tr>
    </c:forEach>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="返回" onclick="ba()">
        </td>
    </tr>

</table>

</body>
</html>

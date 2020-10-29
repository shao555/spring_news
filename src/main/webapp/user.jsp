<%--
  Created by IntelliJ IDEA.
  User: 15278
  Date: 2020/10/25
  Time: 10:19
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


        $(document).ready(function () {
            $("table").attr("bgColor", "#FFFFFF"); //设置表格的背景颜色
            $("tr").attr("bgColor", "#B6B6B6"); //为单数行表格设置背景颜色
            $("tr:even").css("background-color", "#9A9A9A"); //为双数行表格设置背颜色素
            $("table").css("width", "1000px")
        }); //为表格添加样式，设置表格长度为300像素
    </script>

</head>
<body>

<table  align="center" border="1">
    <h1 align="center">用户列表</h1>
    <tr>
        <td>用户编号</td>
        <td>用户姓名</td>
        <td>用户密码</td>
        <td>性别</td>
        <td>年龄</td>
        <td>邮箱</td>
    </tr>

    <c:forEach var="u" items="${list}">
        <tr>
        <td>${u.userID}</td>
        <td>${u.userName}</td>
        <td>${u.userPass}</td>
        <td>${u.sex}</td>
        <td>${u.age}</td>
        <td>${u.email}</td>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <a href="NewsServlet?comm=news">新闻表</a>
        </td>
        <td>
            <a href="TopTitleServlet?comm=title">标题表</a>
        </td>
    </tr>

</table>


</body>
</html>

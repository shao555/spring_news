<%--
  Created by IntelliJ IDEA.
  User: 15278
  Date: 2020/10/24
  Time: 14:16
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

        function del(newsID) {
            var flag = confirm("确定删除这条新闻吗?")
            if (flag == true) {
                location.href="NewsServlet?newsID="+newsID+"&comm=del";
            }
        }

        $(document).ready(function () {
            $("table").attr("bgColor", "#FFFFFF"); //设置表格的背景颜色
            $("tr").attr("bgColor", "#B6B6B6"); //为单数行表格设置背景颜色
            $("tr:even").css("background-color", "#9A9A9A"); //为双数行表格设置背颜色素
            $("table").css("width", "1000px")
        }); //为表格添加样式，设置表格长度为300像素
    </script>

</head>
<body>

<h1 align="center">新闻列表</h1>

<table align="center" border="1">
    <tr>
        <td><strong>新闻标题</strong></td>
        <td><strong>新闻内容</strong></td>
        <td><strong>发送时间</strong></td>
        <td><strong>用户ID</strong></td>
        <td><strong>标题ID</strong></td>
        <td width="50">操作</td>
        <td width="50">操作</td>
    </tr>

<c:forEach var="n" items="${list}">
    <tr>
        <td>${n.newTitle}</td>
        <td>${n.newsContent}</td>
        <td>${n.sendDate}</td>
        <td>${n.userID}</td>
        <td>${n.topID}</td>
        <td>
            <a href="NewsServlet?userID=${n.userID}&comm=show">查看</a>
        </td>
        <td>
<%--            <a href="NewsServlet?newsID=${n.newsID}&comm=del">删除</a>--%>
            <a href="javascript:del(${n.newsID})">删除</a>
        </td>
    </tr>

</c:forEach>

    <tr>
        <td>
            <a href="TopTitleServlet?comm=title">标题表</a>
        </td>
        <td>
            <a href="UserInfoServlet?comm=user">用户表</a>
        </td>
        <td>
            <a href="addnews.jsp">添加</a>
        </td>
    </tr>

</table>


</body>
</html>

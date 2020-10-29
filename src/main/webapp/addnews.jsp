<%--
  Created by IntelliJ IDEA.
  User: 15278
  Date: 2020/10/25
  Time: 11:32
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

            //id选择器  失去焦点事件
            $("#newTitle").blur(checkNewTitle);
            $("#newsContent").blur(checkNewsContent);
            $("#userID").blur(checkUserID);
            $("#topID").blur(checkTopID);
            $("#mytab").submit(function () {
                if (!checkNewTitle() || !checkNewsContent() || !checkUserID() || !checkTopID()) {
                    return false;
                } else {
                    alert("添加成功");
                    return true;
                }

            });

            function checkNewTitle() {
                var newTitle = $("#newTitle").val();
                if (newTitle == null || newTitle == "") {
                    alert("标题不能为空");
                    return false;
                }
                return true;
            }

            function checkNewsContent() {
                var newsContent = $("#newsContent").val();
                if (newsContent == null || newsContent == "") {
                    alert("内容不能为空");
                    return false;
                }
                return true;
            }

            function checkUserID() {
                var userID = $("#userID").val();
                if (userID == null || userID == "") {
                    alert("用户编号不能为空!");
                    return false;
                }
                return true;
            }

            function checkTopID() {
                var topID = $("#topID").val();
                if (topID == null || topID == "") {
                    alert("标题编号不能为空!");
                    return false;
                }
                return true;
            }
        });
    </script>

</head>
<body>

<form action="NewsServlet" method="post" id="mytab">

    <table width="400px" align="center" border="1">
        <tr>
            <%--        <td></td>--%>
            <td colspan="2"><strong>添加新闻</strong></td>
        </tr>
        <tr>
            <td>标题:</td>
            <td>
                <input type="text" id="newTitle" name="newTitle">
            </td>
        </tr>
        <tr>
            <td>新闻内容:</td>
            <td>
                <input type="text" id="newsContent" name="newsContent">
            </td>
        </tr>
        <tr>
            <td>用户编号:</td>
            <td>
                <input type="text" id="userID" name="userID">
            </td>
        </tr>
        <tr>
            <td>标题编号:</td>
            <td>
                <input type="text" id="topID" name="topID">
            </td>
        </tr>
        <tr>
            <%--        <td></td>--%>
            <td colspan="2">
                <input type="submit" name="comm" value="提交">
            </td>
        </tr>
    </table>


</form>

</body>
</html>

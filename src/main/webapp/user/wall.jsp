<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>留言墙 - 浏览</title>
</head>
<body>
<div style="margin-left: 35%; margin-top: 100px; font-family: Microsoft YaHei">
    <h1 style="margin-left: 5%"></h1>
        <table border="1">
            <caption>所有留言信息</caption>
            <tr>
                <th>留言人姓名</th>
                <th>留言时间</th>
                <th>留言标题</th>
                <th>留言内容</th>
            </tr>
        <c:forEach var="comment" items="${commentList }" varStatus="status">
            <tr>
                <td>
                    <span>${comment.nickname}</span>
                </td>
                <td>
                    <span>${comment.datetime}</span>
                </td>
                <td>
                    <span>${comment.title}</span>
                </td>
                <td>
                    <span>${comment.message}</span>
                </td>
            </tr>
        </c:forEach>
        </table>
    <a style="margin-left: 22%" href="index.jsp">主页</a>
    <a href="leavemessage.jsp">留言</a>
</div>
</body>
</html>

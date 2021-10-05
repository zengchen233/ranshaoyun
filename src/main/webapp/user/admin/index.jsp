<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线人员列表 - 管理员</title>
</head>
<body>
<div style="margin-left: 35%; margin-top: 100px; font-family: Microsoft YaHei">
    <h1>当前在线人数为:<span style="color: red"></span>人</h1>
    <table border="1">
        <caption>所有留言信息</caption>
        <tr>
            <th>留言人姓名</th>
            <th>留言时间</th>
            <th>留言标题</th>
            <th>留言内容</th>
        </tr>

    </table>
    <a style="margin-left: 22%" href="${pageContext.request.contextPath}/user">主页</a>
</div>
</body>
</html>

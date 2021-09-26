<%@ page import="cn.zengchen233.pojo.Comment" %>
<%@ page import="cn.zengchen233.utils.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言墙 - 浏览</title>
</head>
<body>
<div style="margin-left: 35%; margin-top: 100px; font-family: Microsoft YaHei">
    <h1 style="margin-left: 5%">这里是留言板主界面</h1>
    <form action="leavemessage.jsp" method="post">
        <table border="1">
            <caption>所有留言信息</caption>
            <tr>
                <th>留言人姓名</th>
                <th>留言时间</th>
                <th>留言标题</th>
                <th>留言内容</th>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </form>
    <a style="margin-left: 22%" href="leavemessage.jsp">留言</a>
</div>
</body>
</html>

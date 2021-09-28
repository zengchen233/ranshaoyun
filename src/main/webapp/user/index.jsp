<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
登陆成功
<hr>

<ul>
    <li><a href="${pageContext.request.contextPath}/user/comment?method=query">留言墙</a></li>
    <li><a href="${pageContext.request.contextPath}/user/leavemessage.jsp">留言</a></li>
</ul>

<a href="${pageContext.request.contextPath}/user/logout.do">注销</a>
</body>
</html>

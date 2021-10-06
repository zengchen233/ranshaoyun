<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线人员列表 - 管理员</title>
</head>
<body>
<div style="margin-left: 35%; margin-top: 100px; font-family: Microsoft YaHei">
    <%
        if(application.getAttribute("allUser") != null){
            List<String> list = (List<String>)application.getAttribute("allUser");
    %>
    <h1>当前在线人数为:<span style="color: greenyellow"><%=list.size()%></span>人</h1>
    <%
        for(String user:list){
    %>
    <a>姓名：</a><%=user%><a>---->此时在线</a><br>
    <%
            }
        }
    %>
    <a style="margin-left: 22%" href="${pageContext.request.contextPath}/user">主页</a>
</div>
</body>
</html>

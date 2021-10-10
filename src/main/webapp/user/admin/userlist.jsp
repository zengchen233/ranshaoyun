<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户列表 - 管理员</title>
</head>
<body>
    <div style="margin-left: 35%; margin-top: 100px; font-family: Microsoft YaHei">
        <form method="get" action="${pageContext.request.contextPath}/user/admin">
            <input name="method" value="query" class="input-text" type="hidden">
            <span>用户名：</span>
            <input name="name" class="input-text" type="text" value="${name}">

            <span>用户角色：</span>
            <select name="queryUserRole">
                <option value="0" selected="selected">--请选择--</option>
                <option value="1">管理员</option>
                <option value="2">用户</option>
            </select>

            <input	value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath}/user/admin">添加用户</a>
        </form>
    </div>
    <!--用户-->
    <div style="margin-left: 35%; margin-top: 100px; font-family: Microsoft YaHei">
        <table border="1">
            <tr>
                <th>用户编码</th>
                <th>用户名称</th>
                <th>电话</th>
                <th>邮箱</th>
                <th>用户角色</th>
                <th>操作</th>
            </tr>
         <c:forEach var="user" items="${userList }" varStatus="status">
             <tr>
                 <td>
                     <span>${user.usercode }</span>
                 </td>
                 <td>
                     <span>${user.nickname }</span>
                 </td>
                 <td>
                     <span>${user.phone}</span>
                 </td>
                 <td>
                     <span>${user.email}</span>
                 </td>
                 <td>
                     <span>${user.rolename}</span>
                 </td>
                 <td>
                     <span></span>
                 </td>
             </tr>
         </c:forEach>
        </table>
    </div>
</body>
</html>



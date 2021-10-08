<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户列表 - 管理员</title>
</head>
<body>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath}/user/admin">
            <input name="method" value="query" class="input-text" type="hidden">
            <span>用户名：</span>
            <input name="name" class="input-text"	type="text" value="${name }">

            <span>用户角色：</span>
            <select name="queryUserRole">
                <option value="0" selected="selected">--请选择--</option>
                <option value="1">管理员</option>
                <option value="2">用户</option>
            </select>

            <input	value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath}">添加用户</a>
        </form>
    </div>
    <!--用户-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="20%">用户编码</th>
            <th width="20%">用户名称</th>
            <%--<th width="10%">性别</th>--%>
            <th width="10%">电话</th>
            <th width="10%">邮箱</th>
            <th width="10%">用户角色</th>
            <th width="30%">操作</th>
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
</section>
</body>
</html>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" href="../static/css/modifypw.css">
    <style>
        .text {
            color: #EF3B3A;
        }
    </style>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/user.do" method="post">
        <input name="method" value="modify" class="input-text" type="hidden">
        <div class="text">${error}</div>
        <div class="text">${message}</div>
        <div class="box">
            <h2>修改密码</h2>
            <div class="form">
                <div class="login-row">
                    <span>旧密码:</span>
                    <input type="text" name="oldpassword" class="input-text" required/>
                </div>
                <div class="login-row">
                    <span>新密码:</span>
                    <input type="password" name="newpassword" class="input-text" required/>
                </div>
                <div class="login-row">
                    <button type="submit" id="login-btn" class="btn" >提&nbsp;交</button>
                    <button type="reset">重&nbsp;置</button>
                </div>
            </div>
        </div>
    </form>
</body>
</html>

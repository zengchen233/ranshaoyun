<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>燃烧云工作室 - 首页</title>

    <link rel="stylesheet" href="static/css/style.css">
    <style>
        .text {
            color: #EF3B3A;
        }
    </style>

</head>
<body>

<div class="login-page">
    <div class="form">
        <form class="register-form" method="post" action="${pageContext.request.contextPath}/reg.do">
            <input type="text" name="usercode" placeholder="账号"/>
            <input type="password" name="password" placeholder="密码"/>
            <input type="text" name="nickname" placeholder="用户名"/>
            <input type="text" name="phone" placeholder="电话号码"/>
            <input type="text" name="email" placeholder="邮箱"/>
            <button>注册</button>
            <p class="message">已经注册? <a href="#">登录</a></p>
        </form>
        <form class="login-form" method="post" action="${pageContext.request.contextPath}/log.do">
            <div class="text">${error}</div>
            <input type="text" name="usercode" placeholder="账号"/>
            <input type="password" name="password" placeholder="密码"/>
            <button>登录</button>
            <p class="message">不是新用户? <a href="#">立即注册</a></p>
        </form>
    </div>
</div>

<script src='static/js/jquery.min.js'></script>
<script src="static/js/script.js"></script>

</body>
</html>

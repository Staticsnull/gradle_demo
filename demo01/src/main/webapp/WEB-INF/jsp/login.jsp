<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

    <h2>登录</h2>
    <form action="/doLogin" method="post">
        <div>${error}</div>
        用户名：<input name="username" type="text"><br>
        邮箱：<input name="email" type="text"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>

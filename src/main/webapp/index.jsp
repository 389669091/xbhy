<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<script src="${path}/static/js/jquery.js"></script>
<script>
    function changeImg() {
        $("#img").attr("src","/img/getCode?nocache="+new Date().getTime())
    }
</script>
<%--<style>--%>
    <%--#img {--%>
        <%--border: solid;--%>
    <%--}--%>
<%--</style>--%>
<body>

<%--<a href="/login">登录</a>--%>
<form action="/login/login" method="post">
    用户名：<input type="text" name="username" value=""><br><br>
    密  码：<input type="text" name="password" value=""><br><br>
    记住我<input type="checkbox" name="remember" value="1"><br><br>
    验证码：<input type="text" name="code" value="">
    <%--<a href="/img/getCode">查看图片</a>--%>
    <img src="/img/getCode" id="img" onclick="changeImg()"><br><br>
    <input type="submit" value="登录">
</form>
<a href="/jsp/login/forget.jsp">忘记密码</a>
</body>
</html>

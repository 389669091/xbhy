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
<style>
    #login{
        margin:100px auto;
       background-image: url("/images/1.jpg");
        width: 500px;
        height: 501px;
        position: relative;
    }
    a{
        text-decoration: none;
    }
    #login-1{
        position: absolute;
        width: 50%;
        height: 350px;
       margin-top: 80px;
        margin-left: 125px;

    }
    #code{
        width: 100px;
    }
    #submit{
        width: 250px;
    }
</style>
<body>
<%--<a href="/login">登录</a>--%>
<div id="login">
    <div id="login-1">
        <h2>小标会议</h2>
<form action="/login/login" method="post">
    用户名：<input type="text" name="username" value=""><br><br>
    密&nbsp;&nbsp;&nbsp;码：<input type="text" name="password" value=""><br><br>
    验证码：<input type="text" name="code" value="" id="code">
    <img src="/img/getCode" id="img" onclick="changeImg()"><br><br>
    记住我<input type="checkbox" name="remember" value="1" >
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;
    <a href="/jsp/login/forget.jsp">忘记密码</a><br><br>
    <%--<a href="/img/getCode">查看图片</a>--%>
    <input type="submit" value="登录" id="submit"><br>
    <a href="/weChat/login" class="btn btn-danger">微信登录</a>
</form>
    </div>
</div>
</body>
</html>

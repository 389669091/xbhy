<%--
  Created by IntelliJ IDEA.
  User: JLB
  Date: 2020/6/28
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
   function send() {
       $.ajax({
           url:"/email",
           type:"get",
           data:{"email": $("#email").val()},
           dataType:"text",
           success:function (data) {
               if (data==1){
                   alert("发送成功")
               }
               else {
                   alert("发送失败")
               }
           }
       })
   }
</script>
<body>
<form action="/login/forget" method="get">
    用户名：<input type="text" name="username" value=""><br><br>
    新密码：<input type="text" name="newPs" value=""><br><br>
    邮&nbsp;&nbsp;&nbsp;箱：<input type="text" name="email" id="email" value=""><br><br>
    验证码：<input type="text" name="code" value="">
    <input type="button" value="发送验证码" onclick="send()"><br><br>
    <input type="submit" value="修改" name="">
</form>
</body>
</html>

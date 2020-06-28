<%--
  Created by IntelliJ IDEA.
  User: JLB
  Date: 2020/6/23
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    $(function () {
        $.ajax({
            url:"/dept/list",
            type:"get",
            data:"",
            dataType:"json",
            success:function (data) {
                var html='<option value="-1">请选择</option>';
                for (var i = 0; i < data.length; i++) {
                    html+='<option value="'+data[i].id+'">'+data[i].name+'</option>'
                }
                $("#deptId").append(html);
            }
        });
    });
    function checkUserName() {
        var name = $("#username").val();
        $.ajax({
            url: "/user/findName",
            data: {"userName": name},
            type: "get",
            dataType: "text",
            success: function (data) {
                if (data == 0) {
                    //清空
                    $("#username").val("");
                    $("#span").attr("hidden", false);
                } else {
                    $("#span").attr("hidden", true);
                }
            }
        });
    }
</script>
<body>
<form action="/user/add" method="post">
    用户名：<input type="text" id="username" name="username" value="" onblur="checkUserName()" >
    <span id="span" style="color: red;" hidden>账号已存在，请重新输入</span><br><br>
    密码：<input type="text" name="password" value=""><br><br>
    邮箱：<input type="text" name="email" value=""><br><br>
    真实姓名：<input type="text" name="realName" value=""><br><br>
    年龄：<input type="text" name="age" value=""><br><br>
    性别：<input type="radio"name="sex" value="1">男
    <input type="radio"name="sex" value="0">女<br><br>
    简介：<textarea name="description"></textarea><br><br>
    部门：<select id="deptId" name="deptId" >
</select><br><br>
    <input type="submit" value="保存">
    <input type="reset" value="重置">
</form>
</body>
</html>

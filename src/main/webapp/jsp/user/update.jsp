<%--
  Created by IntelliJ IDEA.
  User: JLB
  Date: 2020/6/24
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<%--<form action="/user/update" method="post">--%>
    <%--用户名：<input type="text" name="username" value="${user.username}"><br><br>--%>
    <%--邮箱：<input type="text" name="email" value="${user.email}"><br><br>--%>
    <%--真实姓名：<input type="text" name="realName" value="${user.realName}"><br><br>--%>
    <%--年龄：<input type="text" name="age" value="${user.age}"><br><br>--%>
    <%--性别：<input type="radio" name="sex" value="1" <c:if test="${user.sex==1}">checked</c:if>/>男--%>
    <%--<input type="radio" name="sex" value="0" <c:if test="${user.sex==0}">checked</c:if>>女<br><br>--%>
    <%--简介：<textarea name="description">${user.description}</textarea><br><br>--%>
    <%--部门：<select id="deptId" name="deptId">--%>
    <%--<c:forEach var="dept" items="${deptList}">--%>
        <%--<option value="${dept.id}" <c:if test="${user.deptId==dept.id}"> selected</c:if> >${dept.name}</option>--%>
    <%--</c:forEach>--%>
<%--</select>--%>
    <%--<input type="submit" value="提交">--%>
    <%--<input type="reset" value="重置">--%>
    <%--</form>--%>
<div id="right">

    <form action="/user/update" method="post">
        <input type="text" name="id" value="${user.id}" style="display:none">
        用户名：<input type="text" id="username" name="username" value="${user.username}"><br><br>
        邮箱：<input type="text" name="email" value="${user.email}"><br><br>
        真实姓名：<input type="text" name="realName" value="${user.realName}"><br><br>
        年龄：<input type="text" name="age" value="${user.age}"><br><br>
        性别：<input type="radio" name="sex" value="1" <c:if test="${user.sex==1}">checked</c:if>>男
        <input type="radio" name="sex" value="0" <c:if test="${user.sex==0}">checked</c:if>>女<br><br>
        简介：<textarea name="description">${user.description}</textarea><br><br>
        部门：<select id="deptId" name="deptId">
        <c:forEach var="dept" items="${deptList}">
            <option value="${dept.id}"
                    <c:if test="${user.deptId==dept.id}">selected</c:if> >${dept.name}</option>
        </c:forEach>
    </select><br><br>
        <input type="submit" value="保存">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>

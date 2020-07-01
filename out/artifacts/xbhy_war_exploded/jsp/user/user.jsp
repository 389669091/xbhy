<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%@include file="../common/top.jsp"%>
<%@include file="../common/left.jsp"%>
<%--<div id="right">--%>
    <%--<a href="/jsp/user/add1.jsp" class="btn btn-success">添加</a>--%>
    <%--<form action="/user/listAll" method="post">--%>
        <%--用户名：<input type="text" name="username" value="">--%>
        <%--性别：<select name="sex">--%>
        <%--<option value="-1" <c:if test="${sex==-1}">selected</c:if>  >请选择</option>--%>
        <%--<option value="1" <c:if test="${sex==1}">selected</c:if>>男</option>--%>
        <%--<option value="0" <c:if test="${sex==0}">selected</c:if>>女</option>--%>
    <%--</select>--%>
        <%--<input type="submit" value="查询" class="btn btn-info">--%>
    <%--</form>--%>
    <%--<table class="table table-bordered">--%>
        <%--<tr>--%>
            <%--<td>序号</td>--%>
            <%--<td>用户名</td>--%>
            <%--<td>密码</td>--%>
            <%--<td>邮箱</td>--%>
            <%--<td>真实姓名</td>--%>
            <%--<td>年龄</td>--%>
            <%--<td>性别</td>--%>
            <%--<td>注册时间</td>--%>
            <%--<td>操作</td>--%>
        <%--</tr>--%>
  <%--<c:forEach var="user" items="${list}" varStatus="status">--%>
      <%--<tr>--%>
          <%--<td>${status.index+1}</td>--%>
          <%--<td>${user.username}</td>--%>
          <%--<td>${user.password}</td>--%>
          <%--<td>${user.email}</td>--%>
          <%--<td>${user.realName}</td>--%>
          <%--<td>${user.age}</td>--%>
          <%--<td>--%>
          <%--<c:choose>--%>
              <%--<c:when test="${user.sex==1}">男</c:when>--%>
              <%--<c:when test="${user.sex==0}">女</c:when>--%>
              <%--<c:otherwise>其他</c:otherwise>--%>
          <%--</c:choose>--%>
          <%--</td>--%>
          <%--<td>--%>
              <%--&lt;%&ndash;<fmt:formatDate var="registerTime" value="${user.registerTime}" pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>&ndash;%&gt;--%>
                 <%--<fmt:formatDate var="registerTime"  value="${user.registerTime}"  pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>--%>
              <%--${registerTime}--%>
                  <%--</td>--%>
          <%--<td><a href="/user/getUserById?id=${user.id}">修改</a>--%>
          <%--<a href="/user/delete?id=${user.id}">删除</a></td>--%>
      <%--</tr>--%>
  <%--</c:forEach>--%>
    <%--</table>--%>
    <%--&lt;%&ndash;当前页：${page}&ndash;%&gt;--%>
    <%--&lt;%&ndash;总记录数：${count}&ndash;%&gt;--%>
    <%--&lt;%&ndash;总页数：${pageCount}&ndash;%&gt;--%>
    <%--&lt;%&ndash;<a href="/user/list?page=${page}">上一页</a>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<a href="/user/list?page=${page+1}">下一页</a>&ndash;%&gt;--%>
    <%--当前页数：${page.pageCurrent}--%>
    <%--总页数：${page.pageCount}--%>
    <%--总记录数：${page.count}--%>
    <%--<a href="/user/listAll?page=${page.pageCurrent-1>0?page.pageCurrent-1:1}&username=${username}&sex=${sex}">上一页</a>--%>
    <%--<a href="/user/listAll?page=${page.pageCurrent+1>page.pageCount?page.pageCount:page.pageCurrent+1}&username=${username}&sex=${sex}">下一页</a>--%>
<div id="right">
    <a href="/jsp/user/add.jsp" class="btn btn-warning">添加</a>
    <a href="/poi/listForExcel?username=${username}" class="btn btn-info">导出用户表</a><br><br>
    <form action="/user/listAll" method="post">
        用户名：<input type="text" id="username" name="username" value="${username}">
        性别：<select name="sex">
        <option value="-1" <c:if test="${sex==-1}">selected</c:if>  >请选择</option>
        <option value="1" <c:if test="${sex==1}">selected</c:if>>男</option>
        <option value="0" <c:if test="${sex==0}">selected</c:if>>女</option>
    </select>
        <input type="submit" value="查询">
    </form>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>用户名</td>
            <td>真实姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>部门名称</td>
            <td>上次注册时间</td>
            <td>操作</td>
        </tr>

        <c:forEach var="user" items="${page.data}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${user.username}</td>
                <td>${user.realName}</td>
                <td>${user.age}</td>
                <td>
                    <c:choose>
                        <c:when test="${user.sex==1}">男</c:when>
                        <c:when test="${user.sex==0}">女</c:when>
                        <c:otherwise>其他</c:otherwise>
                    </c:choose>
                </td>
                <td>${user.deptName}</td>
                <td>
                    <fmt:formatDate value="${user.registerTime}" pattern="yyyy年MM月dd日 hh:mm:ss"></fmt:formatDate>
                        <%--<fmt:parseDate  value="${registerTime}" pattern="yyyy年MM月dd日 hh:mm:ss" ></fmt:parseDate>--%>
                </td>
                <td><a href="/user/getUserById?id=${user.id}" class="btn btn-info">修改</a>
                    <a href="/user/delete?id=${user.id}" class="btn btn-danger">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    当前页数：${page.pageCurrent}
    总页数：${page.pageCount}
    总记录数：${page.count}
    <a href="/user/listAll?page=${page.pageCurrent-1>0?page.pageCurrent-1:1}&username=${username}&sex=${sex}">上一页</a>
    <a href="/user/listAll?page=${page.pageCurrent+1>page.pageCount?page.pageCount:page.pageCurrent+1}&username=${username}&sex=${sex}">下一页</a>

</div>
</body>
</html>

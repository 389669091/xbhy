<%--
  Created by IntelliJ IDEA.
  User: JLB
  Date: 2020/6/29
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会议</title>
</head>
<body>
<table class="table table-bordered">
<tr>
<td>序号</td>
<td>部门名称</td>
<td>部门id</td>
<td>会议标题</td>
<td>会议内容</td>
<td>发布时间</td>
<td>开始时间</td>
<td>结束时间</td>
<td>会议状态</td>
</tr>
<c:forEach var="meet" items="${list}" varStatus="status">
<tr>
<td>${status.index+1}</td>
<td>${meet.deptName}</td>
<td>${meet.deptId}</td>
<td>${meet.title}</td>
<td>${meet.content}</td>
<td>
<%--<fmt:formatDate var="registerTime" value="${user.registerTime}" pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>--%>
<fmt:formatDate var="publishDate"  value="${meet.publishDate}"  pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>
${publishDate}
</td>
    <td>
            <%--<fmt:formatDate var="registerTime" value="${user.registerTime}" pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>--%>
        <fmt:formatDate var="startTime"  value="${meet.startTime}"  pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>
            ${publishDate}
    </td>
    <td>
            <%--<fmt:formatDate var="registerTime" value="${user.registerTime}" pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>--%>
        <fmt:formatDate var="endTime"  value="${meet.endTime}"  pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>
            ${publishDate}
    </td>
    <td>
        <c:choose>
            <c:when test="${meet.status==1}">未开始</c:when>
            <c:when test="${meet.status==0}">进行中</c:when>
            <c:otherwise>已结束</c:otherwise>
        </c:choose>
    </td>
<td><a href="/user/getUserById?id=${meet.id}">修改</a>
<a href="/user/delete?id=${meet.id}">删除</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>

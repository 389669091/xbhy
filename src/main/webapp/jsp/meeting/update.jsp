<%--
  Created by IntelliJ IDEA.
  User: JLB
  Date: 2020/7/1
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" name="id" value="${meeting.id}" style="display:none">
部门名称：<input type="text" name="title" value="${meeting.title}"><br><br>
会议标题：<input type="text" name="content" value="${meeting.content}"><br><br>
会议内容：<textarea name="content">${meeting.content}</textarea><br><br>
发布时间：<fmt:formatDate value="${meeting.publishDate}" pattern="yyyy年MM月dd日 HH:mm:ss"></fmt:formatDate><br><br>
<%--<input type="text" name="publishDate" value="${meeting.publishDate}"><br><br>--%>
开始时间：<fmt:formatDate value="${meeting.startTime}" pattern="yyyy年MM月dd日 HH:mm:ss"></fmt:formatDate><br><br>
<%--<input type="text" name="startTime" value="${meeting.startTime}"><br><br>--%>
结束时间：<fmt:formatDate value="${meeting.endTime}" pattern="yyyy年MM月dd日 HH:mm:ss"></fmt:formatDate><br><br>
<%--<input type="text" name="endTime" value="${meeting.endTime}"/><br><br>--%>
会议状态：
<c:if test="${meeting.status==0}">未开始</c:if>
<c:if test="${meeting.status==1}">正在进行</c:if>
<c:if test="${meeting.status==2}">已结束</c:if>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会议</title>
</head>
<body>
<%@include file="../common/top.jsp" %>
<%@include file="../common/left.jsp" %>
<div id="right">
    <form action="/meeting/listAll" method="post">
        标题名：<input type="text" id="title" name="title" value="${title}">
        会议状态：<select name="status" id="status">
        <option value="-1"
                <c:if test="${status==-1}">selected</c:if>  >请选择
        </option>
        <option value="0" <c:if test="${status==0}">selected</c:if>>未开始</option>
        <option value="1" <c:if test="${status==1}">selected</c:if>>正在进行</option>
        <option value="2" <c:if test="${status==2}">selected</c:if>>已结束</option>
    </select>
        <input type="submit" value="查询">
    </form>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>部门名称</td>
            <td>会议标题</td>
            <td>会议内容</td>
            <td>发布时间</td>
            <td>开始时间</td>
            <td>结束时间</td>
            <td>会议状态</td>
            <td>操作</td>
        </tr>
        <%--<c:forEach var="meet" items="${list}" varStatus="status">--%>
        <%--<tr>--%>
        <%--<td>${status.index+1}</td>--%>
        <%--<td>${meet.deptName}</td>--%>
        <%--<td>${meet.deptId}</td>--%>
        <%--<td>${meet.title}</td>--%>
        <%--<td>${meet.content}</td>--%>
        <%--<td>--%>

        <%--<fmt:formatDate var="publishDate"  value="${meet.publishDate}"  pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>--%>
        <%--${publishDate}--%>
        <%--</td>--%>
        <%--<td>--%>
        <%--<fmt:formatDate var="startTime"  value="${meet.startTime}"  pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>--%>
        <%--${publishDate}--%>
        <%--</td>--%>
        <%--<td>--%>

        <%--<fmt:formatDate var="endTime"  value="${meet.endTime}"  pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>--%>
        <%--${publishDate}--%>
        <%--</td>--%>
        <%--<td>--%>
        <%--<c:choose>--%>
        <%--<c:when test="${meet.status==1}">未开始</c:when>--%>
        <%--<c:when test="${meet.status==0}">进行中</c:when>--%>
        <%--<c:otherwise>已结束</c:otherwise>--%>
        <%--</c:choose>--%>
        <%--</td>--%>
        <%--</tr>--%>
        <%--</c:forEach>--%>
        <c:forEach var="meet" items="${page.data}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${meet.deptName}</td>
                <td>${meet.title}</td>
                <td>${meet.content}</td>
                <td>
                    <fmt:formatDate value="${meet.publishDate}" pattern="yyyy年MM月dd日 hh:mm:ss"></fmt:formatDate>
                        ${publishDate}
                </td>
                <td>
                    <fmt:formatDate var="startTime" value="${meet.startTime}"
                                    pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>
                        ${startTime}
                </td>
                <td>
                    <fmt:formatDate var="endTime" value="${meet.endTime}"
                                    pattern="yyyy年MM月dd日 HH时mm分ss"></fmt:formatDate>
                        ${endTime}
                </td>
                <td>
                    <c:choose>
                        <c:when test="${meet.status==0}">未开始</c:when>
                        <c:when test="${meet.status==1}">进行中</c:when>
                        <c:otherwise>已结束</c:otherwise>
                    </c:choose>
                </td>
                <td><a href="/meeting/getMeetById?id=${meet.id}" class="btn btn-info">查看</a>

                </td>
            </tr>
        </c:forEach>
    </table>
    当前页数：${page.pageCurrent}
    总页数：${page.pageCount}
    总记录数：${page.count}
    <a href="/meeting/listAll?page=${page.pageCurrent-1>0?page.pageCurrent-1:1}&title=${title}&status=${status}">上一页</a>
    <a href="/meeting/listAll?page=${page.pageCurrent+1>page.pageCount?page.pageCount:page.pageCurrent+1}&title=${title}&status=${status}">下一页</a>
</div>
</body>
</html>

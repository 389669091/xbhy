<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
</head>
<body>
<%@include file="../common/top.jsp"%>
<%@include file="../common/left.jsp"%>
<div id="right">
    <a href="/jsp/dept/add.jsp" class="btn btn-warning">添加</a>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>部门名称</td>
            <td>操作</td>
        </tr
        <c:forEach var="dept" items="${list}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${dept.name}</td>
                <td>
                    <a href="/dept/getDeptById?id=${dept.id}" class="btn btn-info">修改</a>
                    <a href="/dept/delete?id=${dept.id}" class="btn btn-danger">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>学生列表</title>
    <style>
        table {
            border-collapse: collapse;
            width: 600px;
            margin: 20px auto;
        }
        th,td {
            border: 1px solid #000;
            text-align: center;
            padding: 5px;
        }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/student/toAdd">新增学生</a>
<table>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${students}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.gender}</td>
            <td>
                <a href="${pageContext.request.contextPath}/student/toUpdate/${stu.id}">修改</a>
                <a href="javascript:;" onclick="del(${stu.id})">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    function del(id) {
        if (confirm("确定删除？")) {
            location.href = "${pageContext.request.contextPath}/student/delete/" + id;
        }
    }
</script>
</body>
</html>

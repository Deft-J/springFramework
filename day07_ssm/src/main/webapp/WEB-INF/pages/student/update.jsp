<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/update" method="post">
    <input type="hidden" name="id" value="${student.id}">
    <div>
        姓名：<input type="text" name="name" value="${student.name}">
    </div>
    <div>
        年龄：<input type="number" name="age" value="${student.age}">
    </div>
    <div>
        性别：<input type="radio" name="gender" value="男" ${student.gender == '男' ? 'checked' : ''}>男
        <input type="radio" name="gender" value="女" ${student.gender == '女' ? 'checked' : ''}>女
    </div>
    <div>
        <button type="submit">提交</button>
    </div>
</form>
</body>
</html>

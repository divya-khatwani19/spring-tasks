<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>TODO App</title>
</head>
<body>

<h2>Todo List</h2>

<form action="/add" method="post">
    <input type="text" name="task" placeholder="Enter task" required/>
    <button type="submit">Add</button>
</form>

<ul>
    <c:forEach var="todo" items="${todos}">
        <li>
            ${todo.task}
            <a href="/delete/${todo.id}">❌</a>
        </li>
    </c:forEach>
</ul>

</body>
</html>
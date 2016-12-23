<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab11</title>
</head>
<body>
<h1>Гостевая книга</h1>
<form action="/" method="post">
    <p>Введите имя:</p>
    <input type="text" name="name"/>
    <p>Введите послание:</p>
    <input type="text" name="message"/>
    <input type="submit" value="Добавить гостя"/>
</form>

<table cellpadding="10">
    <tr>
        <th>Дата</th>
        <th>Имя</th>
        <th>Послание</th>
    </tr>
    <c:forEach var="guest" items="${guests}">
        <tr>
            <td><c:out value="${guest.date}"/></td>
            <td><c:out value="${guest.name}"/></td>
            <td><c:out value="${guest.message}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

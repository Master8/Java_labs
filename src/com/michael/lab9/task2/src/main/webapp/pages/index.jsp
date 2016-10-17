<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab9</title>
</head>
<body>
<h1>Шифровка/Дешифровка</h1>
<form action="/encode" method="post">
    <p>Введите текст который нужно зашифровать:</p>
    <input type="text" name="src"/>
    <input type="submit" value="Зашифровать"/>
</form>

<form action="/decode" method="post">
    <p>Введите текст который нужно расшифровать:</p>
    <input type="text" name="src"/>
    <input type="submit" value="Расшифровать"/>
</form>

<p>Результат</p>
<p>${result}</p>

</body>
</html>

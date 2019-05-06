<%--
  Created by IntelliJ IDEA.
  User: katya
  Date: 23.04.19
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>

<h1>Авторизация</h1>

<h2>Введите логин и пароль:</h2>

<form action="${pageContext.request.contextPath}/authorization" method="post">
    <table>
        <tr>
            <td><label for="login">Логин:</label></td>
            <td><input type="text" name="login" id="login" value="${login}"></td>
        </tr>

        <tr>
            <td><label for="password">Пароль: </label></td>
            <td><input type="password" name="password" id="password" value="${password}"></td>
        </tr>

        <td colspan="3" style="text-align: center"><input type="submit" name="signup" value="Войти"></td>
    </table>

</form>

</body>
</html>

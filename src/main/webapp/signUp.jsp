<%--
  Created by IntelliJ IDEA.
  User: katya
  Date: 29.05.19
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


Для регистрации введите необходимые данные:

<h1>${requestScope.error1}</h1>
<h1>${requestScope.error2}</h1>
<h1>${requestScope.error3}</h1>


<form action="${pageContext.request.contextPath}/signUp" method="post">
    <table>

        <tr>
            <td><label for="login">Имя:</label></td>
            <td><input type="text" name="name" id="name" value="${name}"></td>
        </tr>


        <tr>
            <td><label for="login">Фамилия:</label></td>
            <td><input type="text" name="last_name" id="last_name" value="${last_name}"></td>
        </tr>


        <tr>
            <td><label for="login">Город:</label></td>
            <td><input type="text" name="city" id="city" value="${city}"></td>
        </tr>

        <tr>
            <td><label for="login">Логин:</label></td>
            <td><input type="text" name="login" id="login" value="${login}"></td>
        </tr>

        <tr>
            <td><label for="password">Пароль: </label></td>
            <td><input type="password" name="password" id="password" value="${password}"></td>
        </tr>

        <tr>
            <td><label for="password2">Повторите пароль: </label></td>
            <td><input type="password" name="password2" id="password2" value="${password2}"></td>
        </tr>


        <tr>
            <td colspan="3" style="text-align: center"><input type="submit" name="signUp" value="Зарегистрироваться">
            </td>
        </tr>

    </table>
</form>

<%--<form action="home.jsp" method="post">--%>

<%--    <table>--%>
<%--        <tr>--%>
<%--            <td colspan="3" style="text-align: center">--%>
<%--                <input type="submit" value="Зарегистрироваться">--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>

<%--</form>--%>

</body>
</html>

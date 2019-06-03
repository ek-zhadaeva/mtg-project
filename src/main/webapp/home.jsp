<%--
  Created by IntelliJ IDEA.
  User: katya
  Date: 23.04.19
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<table>
    <tr>
        <td colspan="3" style="text-align: center">
            <a href="logout"><input type="button" value="Выйти"></a>
        </td>
    </tr>

</table>

<form action="${pageContext.request.contextPath}/home" method="post">

    <table>
        ${requestScope.hello}
        ${requestScope.error}

        <tr>



                Добро пожаловать!

        </tr>

        <tr>
            Здесь Вы можете обмениватиься mtg-картами
        </tr>

        <tr>

            <td colspan="3" style="text-align: center"><input type="submit" name="catalog" value="Посмотреть каталог"></td>
            <td colspan="3" style="text-align: center"><input type="submit" name="shop" value="Купить карты"></td>


        </tr>

    </table>

</form>

</body>
</html>

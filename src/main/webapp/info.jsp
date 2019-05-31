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
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/info" method="post">

    <table>

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

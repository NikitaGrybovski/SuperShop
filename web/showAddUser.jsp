<%-- 
    Document   : showAddUser
    Created on : Sep 28, 2020, 8:07:52 PM
    Author     : ban31
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="createUser" method="post">
            <label>Логин </label>
            <input type="text" name="login">
            <label>Пароль </label>
            <input type="password" name="password">
            <label>Деньги </label>
            <input type="number" name="money">
            
            <input type="submit" value="отправить">
        </form>
    </body>
</html>

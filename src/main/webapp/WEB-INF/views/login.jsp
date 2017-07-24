<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/21/2017
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>


    <link href="resources/styles.css" rel='stylesheet'>
</head>
<body>

<form:form method="POST" action="/loginUser">
    <section>
        <fieldset>
            <legend>
                <strong>Login</strong>
            </legend>
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="userName" id="userName" size="30" tabindex="1" placeholder="User Name"
                               autofocus required></td>
                </tr>
                <tr>
                    <td>Enter Password:</td>
                    <td><input type="password" name="password" id="password" size="30" tabindex="2" placeholder="Password"
                               autofocus
                               required></td>
                </tr>
                <tr>
                    <td><input id="submit" type="submit" value="Submit" tabindex="3"></td>
                </tr>
            </table>
        </fieldset>
    </section>
</form:form>
<footer>
    <p id="validation">
        <a href="/registration" title="login">Don't have an account? Register here.</a>
    </p>
</footer>

</body>
</html>

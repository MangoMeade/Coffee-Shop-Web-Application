<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/1/2017
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Edit Item</title>
</head>
<body>
<p>
    <a href="/">Back to Homepage</a>
</p>
<header><h1>Edit Item</h1></header>
<form:form method="POST" action="/edit">
    <section>
        <fieldset>
            <legend>
                <strong>Create a new item</strong>
            </legend>
            <table>
                <p style="text-align: center">${msg}</p>
                <tr>
                    <td>Item Name:</td>
                    <td><input type="text" name="name" id="name" size="30" tabindex="1" placeholder="${name}"
                               autofocus required></td>
                </tr>
                <tr>
                    <td>price:</td>
                    <td><input type="price" name="price" id="price" size="30" tabindex="2"
                               placeholder="${price}" autofocus
                               required></td>
                </tr>
                <tr>
                    <td>description:</td>
                    <td><input type="description" name="description" id="description" size="45" tabindex="3"
                               placeholder="${description}" ></td>
                </tr>
                <tr>
                    <td>quantity:</td>
                    <td><input type="initialQuantity" name="initialQuantity" id="initialQuantity" size="45" tabindex="4"
                               placeholder="${quantity}" ></td>
                </tr>
                <tr>
                    <td><input id="submit" type="submit" value="Submit" tabindex="5"></td>
                </tr>
            </table>
        </fieldset>
    </section>
</form:form>
<td><a href="profile"><button>Back to Store</button></a> </td>

</body>
</html>

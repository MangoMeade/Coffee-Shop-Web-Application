<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/20/2017
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Store</title>

    <link href="resources/styles.css" rel='stylesheet'>
</head>
<body>
<p>
    <a href="/">Back to Homepage</a>
</p>

<h1>Hello ${name}! Welcome to Aaron's store!</h1><br>


<section>
    <fieldset>
        <legend>
            <strong>Select the items you want below: </strong>
        </legend>
        <table border="1">
            <tr>
                <td>Name</td>
                <td>Description</td>
                <td>Price</td>
                <td>Quantity</td>
                <c:if test="${isMod == true}">
                    <td>delete item</td>
                    <td>edit item</td>
                </c:if>
                <td>Add To Cart</td>
            </tr>
            <c:forEach var="myvar" items="${cList}">
                <tr>
                    <td>${myvar.name}</td>
                    <td>${myvar.description}</td>
                    <td>$${myvar.price}</td>
                    <td>${myvar.initialQuantity}</td>
                    <c:if test="${isMod == true}">
                        <td><a href="delete?id=${myvar.iditems}">delete item</a></td>
                        <td><a href="editItem?id=${myvar.iditems}">edit item</a></td>
                    </c:if>
                    <td>
                        <button onclick="addToList( '${myvar.name}', '${myvar.price}')">Add To Cart</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br><br>
        <c:if test="${isMod == true}">
            <a href="addItems">
                <button>Add Items</button>
            </a>
        </c:if>

    </fieldset>
</section>


<h2>Your Shopping List</h2>
<p id="shoppingList"></p><br>
<h3>Total:</h3>
<p id="totalPrice"></p>


<script src="webapp/resources/shoppingHelper.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/20/2017
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Profile</title>

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
        <tr>
            <td>
                <BUTTON onclick="addToList('Black Coffee',2.00)">Black Coffee</BUTTON>
                $2.00
            </td>
            <td>
                <BUTTON onclick="addToList('Cappuccino',3.00)">Cappuccino</BUTTON>
                $3.00
            </td>
        </tr>
        <br><br>
        <tr>
            <td>
                <BUTTON onclick="addToList('Frappe',3.50)">Frappe</BUTTON>
                $3.50
            </td>
            <td>
                <BUTTON onclick="addToList('Caramel Macchiato',4.00)">Caramel Macchiato</BUTTON>
                $4.00
            </td>
        </tr>
        <br><br>
        <tr>
            <td>
                <BUTTON onclick="addToList('Donut',2.50)">Donut</BUTTON>
                $2.50
            </td>
            <td>
                <BUTTON onclick="addToList('Bagel',2.00)">Bagel</BUTTON>
                $2.00
            </td>
        </tr>
        <br><br>
        <tr>
            <td>
                <BUTTON onclick="removeLastItem()">Remove Last Item</BUTTON>
            </td>
            <td>
                <a href="checkOut"><BUTTON id = "checkOut" name = "checkOut" onclick="return checkOut()">Check Out</BUTTON></a>
            </td>
        </tr>
        <br><br>

    </fieldset>
</section>


<h2>Your Shopping List</h2>
<p id="shoppingList"></p><br>
<h3>Total:</h3>
<p id="totalPrice"></p>


<script src="resources/shoppingHelper.js"></script>
</body>
</html>

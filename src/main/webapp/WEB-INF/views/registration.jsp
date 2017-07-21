<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/20/2017
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 12px;
        }
        h1 {
            text-align:center;
        }
        /*Table Elements*/
        td {
            vertical-align:top;
        }
        fieldset {
            text-align: left;
            padding: 5px;
            background-color: #eee;
        }
        legend {
            background-color: #f93;
            border: 1px solid #f00;
            padding: 5px;
            margin-bottom:5px;
        }
        section {
            width: 550px;
            margin: 20px auto;
        }
        /* Centers validation text */
        #validation {
            text-align:center;
        }
    </style>
</head>
<body>
<p>
    <a href="/">Back to Homepage</a>
</p>
<header><h1>Register</h1></header>
<form:form method="POST" action="/registerUser"
           oninput="x.value=parseInt(range.value)+parseInt(0)">
    <section>
        <h4>Please complete the following information about yourself below.</h4>
        <fieldset>
            <legend>
                <strong>Step 1: Your Information</strong>
            </legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name" size="30" tabindex="1" placeholder="Full Name" autofocus required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" id="email" size="30" tabindex="2" placeholder="Email Address" required></td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td><input type="tel" name="phone" id="phone" size="30" tabindex="3" placeholder="Phone Number" required></td>
                </tr>
                <tr>
                    <td>I am:</td>
                    <td><input type="radio" name="sex" id="CustSexM" value="male" tabindex="4">Male&nbsp;<input type="radio" name="sex" id="CustSexF" value="female" tabindex="5">Female
                    </td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td><input type="range" name="age" id="range" value="0" min="0" max="100" step="1" tabindex="6"><output name="x" for="range"></output> Years Old</td>
                </tr>
            </table>
        </fieldset>
    </section>

    <section>
        <h4>Submit or Reset the form below.</h4>
        <fieldset>
            <legend><strong>Step 2: Send It!</strong></legend>
            <br>
            <input id="submit" type="submit" value="Complete Survey" tabindex="7">&nbsp;
            <input id="reset" type="reset" value="Reset" tabindex="8">
        </fieldset>
    </section>
</form:form>
<footer>
    <p id="validation">
        <a href="http://validator.w3.org/check?uri=referer" title="HTML5 Validation">HTML5 Validation</a>
    </p>
</footer>
</body>
</html>

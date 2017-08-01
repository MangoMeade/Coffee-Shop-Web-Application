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
    <link href="resources/styles.css" rel='stylesheet'>
</head>
<body>
<p>
    <a href="/">Back to Homepage</a>
</p>
<header><h1>Register</h1></header>
<form:form method="POST" action="/registerUser"
           oninput="x.value=parseInt(range.value)+parseInt(0)"
           onSubmit = "return checkForm(this)">
    <section>
        <h4>Please complete the following information about yourself below.</h4>
        <fieldset>
            <legend>
                <strong>Step 1: Your Information</strong>
            </legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name" size="30" tabindex="1" placeholder="Full Name"
                               autofocus required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" id="email" size="30" tabindex="2" placeholder="Email Address"
                               required></td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td><input type="tel" name="phone" id="phone" size="30" tabindex="3" placeholder="Phone Number"
                               required></td>
                </tr>
                <tr>
                    <td>I am:</td>
                    <td><input type="radio" name="sex" id="CustSexM" value="male" tabindex="4">Male&nbsp;<input
                            type="radio" name="sex" id="CustSexF" value="female" tabindex="5">Female
                    </td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td><input type="range" name="age" id="range" value="0" min="0" max="100" step="1" tabindex="6">
                        <output name="x" for="range"></output>
                        Years Old
                    </td>
                </tr>
            </table>
        </fieldset>
    </section>

    <section>
        <h4>Let us know about your favorite types of coffee. Check all that apply.</h4>
        <fieldset>
            <legend><strong>Step 2: Favorite Coffee(s)</strong></legend>
            <br>
            <label>Dark Roast:</label>
            <input name="coffeePrefs" type="checkbox" value="dark" tabindex="7">
            <label>Light Roast:</label>
            <input name="coffeePrefs" type="checkbox" value="light" tabindex="8">
            <label>Mocha:</label>
            <input name="coffeePrefs" type="checkbox" value="mocha" tabindex="9">
            <label>Cappuccino:</label>
            <input name="coffeePrefs" type="checkbox" value="capp" tabindex="10">
            <label>Cold Brew:</label>
            <input name="coffeePrefs" type="checkbox" value="cold" tabindex="11">
            <label>Other:</label>
            <input name="coffeePrefs" type="checkbox" value="other" tabindex="12">
        </fieldset>
    </section>

    <section>
        <h4>How do you prepare your coffee?</h4>
        <fieldset>
            <legend><strong>Step 3: Coffee Options</strong></legend>
            <br>
            <select name="coffee_options" id="coffee_options" tabindex="13">
                <option selected="selected" disabled>Please Select One...</option>
                <option value="cream">Cream</option>
                <option value="sugar">Sugar</option>
                <option value="creamAndSugar">Cream and Sugar</option>
                <option value="pumpkinSpice">PUMPKIN SPICE!!!!</option>
                <option value="other">other</option>
            </select>
        </fieldset>
    </section>

    <section>
        <h4>Please make a username and password.</h4>
        <fieldset>
            <legend>
                <strong>Step 4: Create Username</strong>
            </legend>
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="userName" id="userName" size="30" tabindex="14" placeholder="userName"
                               autofocus required></td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><input type="password" name="password" id="password" size="30" tabindex="15" placeholder="password"
                               required></td>
                </tr>
                <tr>
                    <td>re-enter password:</td>
                    <td><input type="password" name="pw_veri" id="pw_veri" size="30" tabindex="16" placeholder="re-enter password"
                               required></td>
                </tr>
            </table>
        </fieldset>
    </section>

    <section>
        <h4>Submit or Reset the form below.</h4>
        <fieldset>
            <legend><strong>Step 5: Send It!</strong></legend>
            <br>
            <input id="submit" type="submit" value="Complete Registration" tabindex="17">&nbsp;
            <input id="reset" type="reset" value="Reset" tabindex="18">
        </fieldset>
    </section>
</form:form>
<footer>
    <p id="validation">
        <a href="/login" title="login">Already registered? Login here.</a>
    </p>
</footer>

<script src="resources/helper.js"></script>


</body>
</html>

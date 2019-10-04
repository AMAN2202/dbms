<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The User Details</h3>
<form:form method="POST"
           action="/add" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="username">Name</form:label></td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td><form:label path="password">
                Password</form:label></td>
            <td><form:input path="password"/></td>
        </tr>

        <tr>
            <td><form:label path="type">
                Type</form:label></td>
            <td><form:input path="type"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
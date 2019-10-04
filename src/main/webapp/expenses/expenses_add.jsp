<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The User Details</h3>
<form:form method="POST"
           action="" modelAttribute="e">
    <table>


        <% String[] textFields = {"amount", "description", "type"};
            for (int j = 0; j < textFields.length; j++) { %>
        <TR>
            <TD><%=textFields[j]%>:</TD>
            <TD><INPUT TYPE=TEXT NAME=<%=textFields[j]%>></TD>
        </TR>
        <% } %>

        <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
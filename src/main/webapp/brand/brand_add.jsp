<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The User Details</h3>
<form:form method="POST"
           action="" modelAttribute="brand">
    <table>
            <%--        <tr>--%>
            <%--            <td><form:label path="brand_id">brand_id</form:label></td>--%>
            <%--            <td><form:input path="brand_id"/></td>--%>
            <%--        </tr>--%>
            <%--        <tr>--%>
            <%--            <td><form:label path="brand_name">brand_name</form:label></td>--%>
            <%--            <td><form:input path="brand_name"/></td>--%>
            <%--        </tr>--%>
            <%--        <tr>--%>
            <%--        <td><form:label path="logo">logo</form:label></td>--%>
            <%--        <td><form:input path="logo"/></td>--%>
            <%--    </tr>--%>
            <%--        <tr>--%>

        <% String[] textFields = {"brand_id", "brand_name", "logo"};
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
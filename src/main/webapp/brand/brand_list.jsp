<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
</head>
<body>
<h2>How to fetch data from database in Spring MVC</h2>


<table border="1">

    <c:forEach var="b" items="${brands}">
        <tr>

            <td>${b.brand_id}</td>
            <td>${b.logo}</td>
            <td>${b.brand_name}</td>
        </tr>
    </c:forEach>

</table>

</body>

</html>
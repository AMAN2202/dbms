<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>How to fetch data from database in Spring MVC</h2>


<table border="1">

    <c:forEach var="item" items="${items}">
        <tr>

            <td>${item.brand_id}</td>
            <td>${item.cost_price}</td>
            <td>${item.name}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
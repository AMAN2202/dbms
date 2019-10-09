<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<h2>How to fetch data from database in Spring MVC</h2>


<table class="table table-striped">

    <c:forEach var="b" items="${items}">
        <tr>

            <td>${b.item_id}</td>
            <td>${b.quantity}</td>
            <td>
                <button class="btn btn-danger"><a href="/cart/remove/${b.item_id}">Remove</a></button>
            </td>
            <td>
                <button class="btn btn-success"><a href="/cart/add/${b.item_id}">Add</a></button>
            </td>
            <td>
                <button class="btn btn-success"><a href="/cart/delete/${b.item_id}">Delete</a></button>
            </td>

        </tr>
    </c:forEach>

</table>

</body>

</html>
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

            <td>${b.address}</td>
            <td>${b.adharno}</td>
            <td>${b.dob}</td>
            <td>${b.email}</td>
            <td>${b.firstname}</td>
            <td>${b.lastname}</td>
            <td>${b.phoneno}</td>
            <td>${b.zipcode}</td>

        </tr>
    </c:forEach>

</table>

</body>

</html>
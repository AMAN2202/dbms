<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Material Design Bootstrap</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">

    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>
</head>
<body>
<h1 class="text-center">Suppliers</h1>


<table class="col-11 mx-auto table table-striped">
    <thead>
    <th>S.No</th>
    <th>Firstname</th>
    <th>Lastname</th>
    <th>Address</th>
    <th>Adhar</th>
    <th>DOB</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Zip code</th>
    <th>Action</th>
    </thead>
    <c:forEach var="b" items="${items}">
        <tr>
            <td>${b.p.person_id}</td>
            <td>${b.p.firstname}</td>
            <td>${b.p.lastname}</td>
            <td>${b.p.address}</td>
            <td>${b.p.adharno}</td>
            <td>${b.p.dob}</td>
            <td>${b.p.email}</td>

            <td>${b.p.phoneno}</td>
            <td>${b.p.zipcode}</td>
            <td>
                <a class="btn btn-sm btn-info  text-dark" href="/supplier/update/${b.supplier_id}">Update</a>

                <a class="btn btn-sm btn-secondary  text-dark" href="/supplier/${b.supplier_id}">View </a>
                <a class="btn btn-sm btn-danger  text-dark" href="/supplier/remove/${b.person_id}">Delete </a>

            </td>
        </tr>
    </c:forEach>

</table>

</body>

</html>
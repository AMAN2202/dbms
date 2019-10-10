<%--
  Created by IntelliJ IDEA.
  User: aman
  Date: 11/10/19
  Time: 12:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

<h1 class="text-center">
    Employee Detail
</h1>
<div class="container">
    <table class="table table-striped col-10 mx-auto">
        <tr>
            <td>
                Firstname
            </td>
            <td class="text-info font-weight-bolder">
                ${b.p.firstname}
            </td>
        </tr>
        <tr>
            <td>
                Lastname
            </td>
            <td class="text-info font-weight-bolder">
                ${b.p.lastname}
            </td>
        </tr>
        <tr>
            <td>
                Username
            </td>
            <td class="text-info font-weight-bolder">
                ${b.username}
            </td>
        </tr>
        <tr>
            <td>
                DOB
            </td>
            <td class="text-info font-weight-bolder">
                ${b.p.dob}
            </td>
        </tr>
        <tr>
            <td>
                Salary
            </td>
            <td class="text-info font-weight-bolder">
                ${b.salary}
            </td>
        </tr>
        <tr>
            <td>
                Balance
            </td>
            <td class="text-info font-weight-bolder">
                ${b.balance}
            </td>
        </tr>
        <tr>
            <td>
                Adharno
            </td>
            <td class="text-info font-weight-bolder">
                ${b.p.adharno}
            </td>
        </tr>
        <tr>
            <td>
                Phoneno
            </td>
            <td class="text-info font-weight-bolder">
                ${b.p.phoneno}
            </td>
        </tr>
        <tr>
            <td>
                Address
            </td>
            <td class="text-info font-weight-bolder">
                ${b.p.address}
            </td>
        </tr>
        <tr>
            <td>
                Zipcode
            </td>
            <td class="text-info font-weight-bolder">
                ${b.p.zipcode}
            </td>
        </tr>

    </table>
    <div class="text-center">
        <a class="btn btn-sm btn-success  text-dark" href="/employee/update/${b.employee_id}">Update</a>
        <a class="btn btn-sm btn-danger  text-dark" href="/employee/remove/${b.employee_id}">Delete</a>
    </div>
</div>

</body>
</html>

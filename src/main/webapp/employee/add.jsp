<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1 class="text-center text-capitalize">${action} Employee Detail</h1>
<!-- product-list -->
<div class="container">
    <form:form method="POST"
               action="/employee/add" modelAttribute="emp">

        <table class="table-striped table col-8 mx-auto">
            <form:hidden path="employee_id"/>
            <form:hidden path="person_id"/>
            <tr>
                <td>Salary</td>
                <td><form:input path="salary" class="form-control"/></td>
            </tr>
            <tr>
                <td>balance</td>
                <td><form:input path="balance" class="form-control"/></td>
            </tr>
            <tr>
                <td>Username</td>
                <td><form:input path="username" class="form-control"/></td>
            </tr>
            <tr>
                <td>Firstname</td>
                <td><form:input path="p.firstname" class="form-control"/></td>
            </tr>
            <tr>
                <td>DOB</td>
                <td><form:input path="p.dob" class="form-control"/></td>
            </tr>

            <tr>
                <td>Lastname</td>
                <td><form:input path="p.lastname" class="form-control"/></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><form:input path="p.gender" class="form-control"/></td>
            </tr>
            <tr>
                <td>Zipcode</td>
                <td><form:input path="p.zipcode" class="form-control"/></td>
            </tr>


            <tr>
                <td>Address</td>
                <td><form:input path="p.address" class="form-control"/></td>
            </tr>
            <tr>
                <td>Adhar</td>
                <td><form:input path="p.adharno" class="form-control"/></td>
            </tr>
            <tr>
                <td>phoneno</td>
                <td><form:input path="p.phoneno" class="form-control"/></td>
            </tr>
            <tr>
                <td>
                    Email
                </td>
                <td>
                    <form:input path="p.email" class="form-control"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" class="btn btn-secondary text-center" name="cancel" value="Cancel">
                    <input type="submit" name="submit" class="btn btn-success text-center" value="${action}"/></td>
            </tr>
        </table>

    </form:form>

</div>
</Body>

</html>
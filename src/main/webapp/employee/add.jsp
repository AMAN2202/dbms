<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<!-- product-list -->
<div class="container">
    <form:form method="POST"
               action="/employee/add" modelAttribute="emp">

        <table class="table-striped table">
            <form:hidden path="employee_id"/>
            <form:hidden path="person_id"/>
            <tr>
                <td>Salary</td>
                <td><form:input path="salary"/></td>
            </tr>
            <tr>
                <td>balance</td>
                <td><form:input path="balance"/></td>
            </tr>
            <tr>
                <td>Username</td>
                <td><form:input path="username"/></td>
            </tr>
            <tr>
                <td>Firstname</td>
                <td><form:input path="p.firstname"/></td>
            </tr>
            <tr>
                <td>DOB</td>
                <td><form:input path="p.dob"/></td>
            </tr>

            <tr>
                <td>Lastname</td>
                <td><form:input path="p.lastname"/></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><form:input path="p.gender"/></td>
            </tr>
            <tr>
                <td>Zipcode</td>
                <td><form:input path="p.zipcode"/></td>
            </tr>


            <tr>
                <td>Address</td>
                <td><form:input path="p.address"/></td>
            </tr>
            <tr>
                <td>Adhar</td>
                <td><form:input path="p.adharno"/></td>
            </tr>
            <tr>
                <td>phoneno</td>
                <td><form:input path="p.phoneno"/></td>
            </tr>
            <tr>
                <td>
                    Email
                </td>
                <td>
                    <form:input path="p.email"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" class="btn btn-primary" value="Submit"/></td>
            </tr>
        </table>

    </form:form>

</div>
</Body>

</html>
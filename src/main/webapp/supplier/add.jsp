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
               action="/supplier/add" modelAttribute="person">

        <table class="table-striped table">
            <form:hidden path="person_id"/>
            <tr>
                <td>Firstname</td>
                <td><form:input path="firstname"/></td>
            </tr>
            <tr>
                <td>DOB</td>
                <td><form:input path="dob"/></td>
            </tr>

            <tr>
                <td>Lastname</td>
                <td><form:input path="lastname"/></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><form:input path="gender"/></td>
            </tr>
            <tr>
                <td>Zipcode</td>
                <td><form:input path="zipcode"/></td>
            </tr>


            <tr>
                <td>Address</td>
                <td><form:input path="address"/></td>
            </tr>
            <tr>
                <td>Adhar</td>
                <td><form:input path="adharno"/></td>
            </tr>
            <tr>
                <td>phoneno</td>
                <td><form:input path="phoneno"/></td>
            </tr>
            <tr>
                <td>
                    Email
                </td>
                <td>
                    <form:input path="email"/>
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
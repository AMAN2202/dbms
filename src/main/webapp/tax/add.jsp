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
               action="/tax/add" modelAttribute="tax">

        <table class="table-striped table">
            <form:hidden path="income_tax_id"/>
            <tr>
                <td>Amount</td>
                <td><form:input path="amount"/></td>
            </tr>
            <tr>
                <td>
                    Penality
                </td>
                <td>
                    <form:input path="penality"></form:input>
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
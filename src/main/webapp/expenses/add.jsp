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
<h1 class="text-center">Update Expence</h1>
<!-- product-list -->

    <form:form method="POST"
               action="/exp/add" modelAttribute="exp">

        <table class="mx-auto col-4 table-striped table">
            <form:hidden path="expenses_id"/>
            <tr>
                <td>Expense Type</td>
                <td><form:input path="type" class="form-control"/></td>
            </tr>
            <tr>
                <td>
                    description
                </td>
                <td>
                    <form:input path="description" class="form-control"></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    amount
                </td>
                <td>
                    <form:input path="amount" class="form-control"></form:input>
                </td>
            </tr>


        </table>
        <div class="text-center">
            <input type="submit" class="btn btn-secondary text-center" name="cancel" value="Cancel">
            <input type="submit" name="submit" class="btn btn-success text-center" value="${action}}"/>
        </div>

    </form:form>


</Body>

</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link href="../mdb.css" rel="stylesheet">

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
            src="../mdb.js"></script>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark primary-color">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${user.type =='a'}">
                    <li class="nav-item">
                        <a class="nav-link" href="/item">Item <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/brand">Brand</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/employee">Employee</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/supplier">Supplier</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/supplier">Customers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Users">Users</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/exp">Expenses</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/tax">Tax</a>
                    </li>

                </c:when>
                <c:when test="${user.type=='employee'}">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                </c:when>
                <c:when test="${user.type== 'customer'}">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                </c:when>
            </c:choose>

        </ul>
    </div>
</nav>
<h1 class=" text-center">Expenses</h1>


<table class="table table-striped col-8 mx-auto">
    <b>
        <thead>
        <th>
            S.No
        </th>
        <th>
            Type
        </th>
        <th>
            Description
        </th>
        <th>
            Date
        </th>
        <th>
            Amount
        </th>
        <th>
            Action
        </th>
        </thead>
    </b>
    <c:forEach var="b" items="${items}">
        <tr>

            <td>${b.expenses_id}</td>
            <td>${b.type}</td>
            <td>${b.description}</td>
            <td>${b.date}</td>
            <td>${b.amount}</td>
            <td>
                <a class="btn btn-sm btn-primary  text-dark" href="/exp/update/${b.expenses_id}">Update</a>

                <a class="btn btn-sm btn-secondary  text-dark" data-toggle="modal"
                   data-target="#basicExampleModal${b.expenses_id}">View </a>
                <a class="btn btn-sm btn-danger  text-dark" href="/exp/remove/${b.expenses_id}">Delete </a>

            </td>
        </tr>


        <!-- Modal -->
        <div class="modal fade" id="basicExampleModal${b.expenses_id}" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel${b.expenses_id}"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title text-capitalize text-info"
                            id="exampleModalLabel${b.expenses_id}">${b.type}</h5>
                        <div class="float-lg-right text-info">${b.date}</div>

                    </div>
                    <div class="modal-body">
                        <div class="text-info">${b.description}</div>
                        <div class="text-danger float-lg-left">Amount: ${b.amount}</div>
                    </div>
                    <div class="modal-footer">

                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

    </c:forEach>

</table>
<div class="container">
    <a class="btn btn-lg btn-success float-lg-right text-dark" href="/exp/add">ADD </a>
</div>
</body>

</html>
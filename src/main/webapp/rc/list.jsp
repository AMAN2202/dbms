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
<h1 class="text-center">Reciept</h1>

<div class="row">
    <div class="col-3 text-center ml-auto">

        <h1 class="text-info">Filter</h1>
        <center>
            <form action="/filteremp" method="get" modelAttribute="filter">

                <% String[] textFields = {"e.salary", "p.phoneno", "p.email", "e.username", "p.firstname", "p.lastname", "e.username", "e.balance", "p.gender", "p.zipcode", "age"};
                    for (int j = 0; j < textFields.length; j++) { %>


                <div class="md-form">

                    <label for="<%=textFields[j]%>"><%=textFields[j]%>
                    </label>
                    <INPUT TYPE=TEXT NAME=<%=textFields[j]%> id="<%=textFields[j]%>" class="form-control col-5">

                </div>
                <% } %>

                <button type="submit" class="btn btn-secondary">Search</button>
            </form>
        </center>


    </div>
    <div class="col-8 mr-auto">
        <table class="table table-striped mx-2">
            <thead>
            <th>S. No</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Username</th>
            <th>Email</th>
            <th>Phone no</th>
            <th>Salary</th>
            <th>Action</th>
            </thead>
            <c:forEach var="b" items="${items}">
                <tr class="product">
                    <td>${b.receipt_id}</td>
                    <td>${b.date}</td>
                    <td>${b.amount}</td>
                    <td>${b.amount_payed}</td>
                        <%--            <td>${b.p.address}</td>--%>
                        <%--            <td>${b.p.adharno}</td>--%>
                        <%--            <td>${b.p.dob}</td>--%>
                    <td>${b.discount}</td>
                        <%--                    <td>${b.p.phoneno}</td>--%>
                        <%--                        &lt;%&ndash;            <td>${b.p.zipcode}</td>&ndash;%&gt;--%>
                        <%--                        &lt;%&ndash;            <td>${b.balance}</td>&ndash;%&gt;--%>
                        <%--                    <td>${b.salary}</td>--%>
                        <%--                    <td>--%>
                        <%--                        <a class="btn btn-sm btn-primary  text-dark" href="/employee/update/${b.employee_id}">Update</a>--%>
                        <%--                        <a class="btn btn-sm btn-secondary  text-dark" href="/employee/${b.employee_id}">View </a>--%>
                        <%--                        <a class="btn btn-sm btn-danger  text-dark" href="/employee/remove/${b.employee_id}">Delete</a>--%>

                        <%--                    </td>--%>
                </tr>


            </c:forEach>

        </table>
        <div class="container">
            <a class="btn btn-lg btn-success float-lg-right text-dark" href="/employee/add">ADD </a>
        </div>
    </div>
</div>

<div class="container fixed-bottom mb-5">
    <h4>
        <div class="row">
            <div class="text-info col-6">
                <div class="float-right"><br>Page No:</div>
            </div>

            <ul id="pagin" class="pagination col-6 ">
            </ul>
        </div>
    </h4>
</div>


</div>

<script type="text/javascript">
    //Pagination
    pageSize = 8;

    var pageCount = ${items.size()/8};

    for (var i = 0; i < pageCount; i++) {
        $("#pagin").append('<li class="page-item btn btn-sm"><a class="page-link" href="#">' + (i + 1) + '</a></li> ');
    }

    showPage = function (page) {
        $(".product").hide();
        $(".product").each(function (n) {
            if (n >= pageSize * (page - 1) && n < pageSize * page)
                $(this).show();

        });
    };

    showPage(1);

    $("#pagin li a").click(function () {
        $("#pagin li a").removeClass("current");
        $(this).addClass("current");
        showPage(parseInt($(this).text()))
    });


</script>

</script>
<
/body>

< /html>;;
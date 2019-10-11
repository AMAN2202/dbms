<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<h1 class="text-center text-info">Cart</h1>
<c:choose>
    <c:when test="${empty items}">
        <br>
        <br>
        <br>
        <br>
        <div class="card ui-widget-shadow col-6 mx-auto mt-3">
            <h2 class=" mt-5 text-danger text-center">Sorry. Your Cart is Empty</h2>
            <h3 class=" text-center mt-3">Please add items and then come here to checkout.</h3>
            <div class="col-4 mx-auto">
                <a class="btn btn-success" href="/item">Go to Item Page</a>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <table class="table product-table container ">
            <thead>
            <th>
                Image
            </th>
            <th>
                Item
            </th>
            <th>
                Mrp
            </th>
            <th>
                Discount
            </th>
            <th>
                Quantity
            </th>
            <th>
                Subtottal
            </th>

            </thead>
            <c:forEach var="b" items="${items}">
                <tr>
                    <td>
                        <img src="${b.i.imgurl}" class="img-fluid" width="200px"/>
                    </td>

                    <td>${b.i.name}</td>
                    <td>$${b.i.mrp}</td>
                    <td>${b.i.discount}%</td>
                    <td>${b.quantity}</td>
                    <td>
                        $${b.quantity*b.i.mrp*(1-b.i.discount/100)}
                    </td>


                </tr>
            </c:forEach>

        </table>
        <div class="container mx-auto">


            <form:form method="POST" action="" modelAttribute="vc">
                <div class="row mt-4">
                    <div class="col-8 text-info">
                        Choose Voucher
                        <form:select path="id" class="mdb-select col-2" items="${bl}"/>
                    </div>
                    <div class="col-4">
                        <div class="text-danger">Total:$${total}</div>
                        <input type="submit" name="cancel" class="btn btn-success" value="Cart"/>
                        <input type="submit" name="submit" class="btn btn-success" value="Checkout"/>
                    </div>
                </div>
            </form:form>

        </div>
    </c:otherwise>
</c:choose>


</body>
<script type="text/javascript">


    $(document).ready(function () {
        $('.mdb-select').material_select();
    });
    <c:choose>
    <c:when test="${empty message}">

    </c:when>
    <c:otherwise>
    $(function () {
        toastr["success"]("${message}");
    });
    </c:otherwise>
    </c:choose>
    <c:choose>
    <c:when test="${empty message2}">

    </c:when>
    <c:otherwise>
    $(function () {
        toastr["warning"]("${message2}");
    });
    </c:otherwise>
    </c:choose>
</script>

</html>
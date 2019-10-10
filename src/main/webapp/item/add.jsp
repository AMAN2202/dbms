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


<div class="bs-example">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top mt-3">
        <a href="#" class="navbar-brand">Brand</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav">
                <a href="#" class="nav-item nav-link active">Home</a>
                <a href="#" class="nav-item nav-link">Profile</a>
                <a href="#" class="nav-item nav-link">Messages</a>
                <a href="#" class="nav-item nav-link disabled" tabindex="-1">Reports</a>
            </div>
            <div class="navbar-nav ml-auto">
                <a href="#myModal" data-toggle="modal">Login</a>
            </div>
        </div>
    </nav>
    <!-- login -->
    <div id="myModal" class="modal fade">
        <div class="modal-dialog modal-login">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="avatar"><i class="material-icons">&#xE7FD;</i></div>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <form action="/examples/actions/confirmation.php" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Username" required="required">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Password" required="required">
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary btn-block btn-lg" value="Login">
                        </div>
                    </form>
                    <div class="hint-text small"><a href="#">Forgot Your Password?</a></div>
                </div>
            </div>
        </div>
    </div>

    <!-- product-list -->
    <div class="container">
        <form:form method="POST"
                   action="" modelAttribute="item">

            <table class="table-striped table">
                <tr>
                    <td>Brand</td>

                    <td><form:select path="brand_id" class="form-contol col-5" items="${bl}"/></td>
                </tr>
                <% String[] textFields = {"category", "cost_price", "discount", "imgurl", "mrp", "name", "qt_avail", "rating", "sold_qt", "description"};
                    for (int j = 0; j < textFields.length; j++) { %>
                <TR>
                    <TD><%=textFields[j]%>:</TD>
                    <TD><INPUT TYPE=TEXT NAME=<%=textFields[j]%> class="form-control col-5"></TD>
                </TR>
                <% } %>
                <tr>
                    <td></td>
                    <td><input type="submit" class="btn btn-primary" value="Submit"/></td>
                </tr>
            </table>

        </form:form>
    </div>
</div>
</Body>

</html>
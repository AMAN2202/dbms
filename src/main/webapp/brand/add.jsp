<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <style>
        .bs-example {
            margin: 30px;
        }

        /* range-slider */


        /* product list */
        body {
            background: #00b09b;
            background: -webkit-linear-gradient(to right, #00b09b, #96c93d);
            background: linear-gradient(to right, #00b09b, #96c93d);
            min-height: 100vh;
        }

        /* login */
        body {
            font-family: 'Varela Round', sans-serif;
        }

        .form-control {
            box-shadow: none;
            border-color: #ddd;
        }

        .form-control:focus {
            border-color: #FB6E9D;
            box-shadow: 0 0 8px rgba(251, 110, 157, 0.4);
        }

        .modal-login {
            color: #434343;
            width: 350px;
        }

        .modal-login .modal-content {
            padding: 20px;
            border-radius: 1px;
            border: none;
            position: relative;
        }

        .modal-login .modal-header {
            border-bottom: none;
        }

        .modal-login h4 {
            text-align: center;
            font-size: 22px;
            margin-bottom: -10px;
        }

        .modal-login .avatar {
            color: #fff;
            margin: 0 auto;
            text-align: center;
            width: 100px;
            height: 100px;
            border-radius: 50%;
            z-index: 9;
            background: lightgreen;
            padding: 15px;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
        }

        .modal-login .avatar i {
            font-size: 62px;
        }

        .modal-login .form-control,
        .modal-login .btn {
            min-height: 40px;
            border-radius: 1px;
            transition: all 0.5s;
        }

        .modal-login .hint-text {
            text-align: center;
            padding-top: 10px;
        }

        .modal-login .close {
            position: absolute;
            top: 15px;
            right: 15px;
        }

        .modal-login .btn {
            background: green;
            border: none;
            line-height: normal;
        }

        .modal-login .btn:hover,
        .modal-login .btn:focus {
            background: green;
        }

        .modal-login .hint-text a {
            color: lightgreen;
        }

        .trigger-btn {
            display: inline-block;
            margin: 100px auto;
        }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
                   action="/brand/save" modelAttribute="brand">

            <table class="table-striped table">
                <form:hidden path="brand_id"/>
                <tr>
                    <td>Brand name</td>
                    <td><form:input path="brand_name"/></td>
                </tr>
                <tr>
                    <td>
                        logo
                    </td>
                    <td>
                        <form:input path="logo"></form:input>
                    </td>
                </tr>

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
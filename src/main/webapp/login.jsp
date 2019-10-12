<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
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


<h1 class="text-center">Log in</h1>


<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>User:</td>--%>
<%--            <td><input type='text' name='username' value=''></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Password:</td>--%>
<%--            <td><input type='password' name='password'/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><input name="submit" type="submit" value="submit"/></td>--%>
<%--        </tr>--%>
<%--    </table>--%>


<!-- Material form login -->

<div class="card col-lg-4 col-sm-8 col-md-6 mx-auto mt-4">

    <h5 class="card-header info-color white-text text-center py-4">
        <strong>Sign in</strong>
    </h5>

    <!--Card content-->
    <div class="card-body px-lg-5 pt-0">

        <!-- Form -->
        <div class="red-text text-center">${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
        <form action="login" method='POST' class="text-center" style="color: #757575;">

            <!-- Email -->
            <div class="md-form">
                <input type='text' name='username' value='' id="username" class="form-control">
                <label for="username">E-mail</label>
            </div>

            <!-- Password -->
            <div class="md-form">
                <input type="password" name="password" id="materialLoginFormPassword" class="form-control">
                <label for="materialLoginFormPassword">Password</label>
            </div>


            <!-- Sign in button -->
            <input name="submit" class="btn btn-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit"
                   value="Sign in"/>

            <!-- Register -->
            <p>Not a member?
                <a href="/add">Register</a>
            </p>


        </form>
        <!-- Form -->

    </div>

</div>
<!-- Material form login -->
</body>
</html>
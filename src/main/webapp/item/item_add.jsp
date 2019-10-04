<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The User Details</h3>
<form:form method="POST"
           action="" modelAttribute="item">
    <table>
        <tr>
            <td><form:label path="brand_id">brand</form:label></td>
            <td><form:input path="brand_id"/></td>
        </tr>
        <tr>
            <td><form:label path="item_id">item_id</form:label></td>
            <td><form:input path="item_id"/></td>
        </tr>
        <tr>
            <td><form:label path="category">category</form:label></td>
            <td><form:input path="category"/></td>
        </tr>
        <tr>
            <td><form:label path="cost_price">cost</form:label></td>
            <td><form:input path="cost_price"/></td>
        </tr>
        <tr>
            <td><form:label path="discount">discount</form:label></td>
            <td><form:input path="discount"/></td>
        </tr>
        <tr>
            <td><form:label path="imgurl">img</form:label></td>
            <td><form:input path="imgurl"/></td>
        </tr>
        <tr>
            <td><form:label path="mrp">mrp</form:label></td>
            <td><form:input path="mrp"/></td>
        </tr>
        <tr>
            <td><form:label path="name">name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="quantity_available">quantity</form:label></td>
            <td><form:input path="quantity_available"/></td>
        </tr>
        <tr>
            <td><form:label path="voucher_credit">benifits</form:label></td>
            <td><form:input path="voucher_credit"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
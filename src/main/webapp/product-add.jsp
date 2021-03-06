<%--
  Created by IntelliJ IDEA.
  User: Miszcz
  Date: 17-Sep-19
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<html>
<head>
    <link rel="stylesheet" href="/style.css">
    <title>Product add</title>
</head>
<body>
<jsp:include page="/navigator.jsp"/>
<form action="${requestScope.productId==null ? '/product-add' : '/product-edit'}" method="post">
    <input type="hidden" name="invoice_getting_products" value="${requestScope.invoiceId}">
    <input type="hidden" name="product_id" value="${requestScope.productId}">
    Product name: <input type="text" name="product_name" value="${requestScope.productName}">
    Product price: <input type="number" min="0.01" step="0.01" name="product_price" value="${requestScope.productPrice}">
<select name="product_taxtype" value="${requestScope.productTaxType}">
    <option value="PRODUCTS">Product(23%)</option>
    <option value="SERVICES">Service(8%)</option>
</select>
    Product's stock: <input type="number" name="product_stock" value="${requestScope.productStock}">
    <br/>
    <input type="submit">
</form>
</body>
</html>

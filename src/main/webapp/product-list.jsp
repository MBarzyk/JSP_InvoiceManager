<%@ page import="java.time.format.DateTimeFormatter" %>
<%--
  Created by IntelliJ IDEA.
  User: Miszcz
  Date: 17-Sep-19
  Time: 20:55
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
    <title>Product List</title>
</head>
<body>
<jsp:include page="/navigator.jsp"/>
<table align="center">
    <br/>
    <tr>
        <th>Id.</th>
        <th>Name</th>
        <th>Price</th>
        <th>Tax Value</th>
        <th>Tax Type</th>
        <th>Stock</th>
        <th>Which Invoice</th>
    </tr>
    <c:if test="${requestScope.gradeList.isEmpty()}">
        <tr><td colspan="7"><p align="center">No products in this Invoice</p></td></tr>
    </c:if>
    <c:if test="${!requestScope.productList.isEmpty()}">
        <c:forEach var="product" items="${requestScope.productList}">
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getTaxValue()}</td>
                <td>${product.getTaxType().toString()}</td>
                <td>${product.getStock()}</td>
                <td>${product.getInvoice().getId()}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>

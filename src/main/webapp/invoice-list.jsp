<%@ page import="java.time.format.DateTimeFormatter" %>
<%--
  Created by IntelliJ IDEA.
  User: Miszcz
  Date: 19-Sep-19
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<html>
<head>
    <link rel="stylesheet" href="/style.css"/>
    <title>List Invoices</title>
</head>
<body>
<jsp:include page="/navigator.jsp"/>
<table style="width: 75%" align="center">
    <br/>
    <tr>
        <th>Id.</th>
        <th>Date of Creation</th>
        <th>Client's Name</th>
        <th>Client's NIP</th>
        <th>Client's Address</th>
        <th>Paid</th>
        <th>Date of Release</th>
        <th>Date of Payment</th>
        <th>Bill value</th>
        <th>Number of Products</th>
    </tr>
    <c:forEach var="invoice" items="${requestScope.invoiceList}">
    <tr>
        <td>${invoice.getId()}</td>
        <td>${invoice.getDateOfCreation().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))}</td>
        <td>${invoice.getClientName()}</td>
        <td>${invoice.getClientNip()}</td>
        <td>${invoice.getClientAddress()}</td>
        <td>${invoice.isPaid()}</td>
        <c:if test="${invoice.dateOfRelease!=null}">
            <td>${invoice.getDateOfRelease().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))}</td>
        </c:if>
        <c:if test="${invoice.dateOfRelease==null}">
            <td><p align="center">not released</p></td>
        </c:if>
        <c:if test="${invoice.dateOfPayment!=null}">
            <td>${invoice.getDateOfPayment().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))}</td>
        </c:if>
        <c:if test="${invoice.dateOfPayment==null}">
            <td><p align="center">not paid</p></td>
        </c:if>
        <c:if test="${invoice.billValue !=null}">
            <td>${invoice.getBillValue()}</td>
        </c:if>
        <c:if test="${invoice.billValue ==null}">
            <td><p align="center">n/a</p></td>
        </c:if>
        <td>${invoice.productList.size()}</td>
        <td>
            <table>
                <tr>
                    <c:if test="${invoice.dateOfRelease==null}">
                        <td>
                            <a class="btn btn-primary" href="/product-add?invoiceId=${invoice.getId()}" role="button">Add product</a>
                        </td>
                    </c:if>
                    <td>
                        <a class="btn btn-primary" href="/product-list?invoiceId=${invoice.getId()}" role="button">List products</a>
                    </td>
                    <c:if test="${invoice.dateOfRelease==null && !invoice.getProductList().isEmpty()}">
                        <td>
                            <a class="btn btn-primary" href="/invoice-set-release?invoiceId=${invoice.getId()}" role="button">Release invoice</a>
                        </td>
                    </c:if>
                    <c:if test="${invoice.dateOfRelease!=null && invoice.paid==false}">
                        <td>
                            <a class="btn btn-primary" href="/invoice-set-paid?invoiceId=${invoice.getId()}" role="button">Set as paid</a>
                        </td>
                    </c:if>
                </tr>
            </table>
        </td>
    </tr>
    </c:forEach>

</body>
</html>

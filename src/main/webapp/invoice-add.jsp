<%--
  Created by IntelliJ IDEA.
  User: Miszcz
  Date: 19-Sep-19
  Time: 19:29
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
    <title>Add Invoice</title>
</head>
<body>
<jsp:include page="/navigator.jsp"/>
<form action="/invoice-add" method="post">
    <input type="hidden" name="invoice_Id" value="${requestScope.invoiceId}">
    Client's name: <input type="text" name="client_name">
    <br/>
    Client's NIP: <input type="text" minlength="10" maxlength="10" name="client_nip">
    <br/>
    Client's address: <input type="text" name="client_address">
    <br/>
    <br/>
    <input type="submit">
</form>
</body>
</html>

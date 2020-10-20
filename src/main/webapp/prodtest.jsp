<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<% String path = request.getContextPath(); %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<span>${prod.name}</span><br/>
<span>${prod.price}</span><br/>
<img src="${prod.picture}"/>

</body>
</html>
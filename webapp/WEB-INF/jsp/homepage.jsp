<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="refresh" content="<%=session.getMaxInactiveInterval()%>;url=login"/>
	<script src="<c:url value="resources/jquery.js" />" type="text/javascript"></script>
	
    <title>User page</title>
</head>
<body>
    Dear <strong>${user}</strong>, Welcome to User Page.
    <a href="<c:url value="/logout?logSucc=true" />">Logout</a>
</body>
</html>
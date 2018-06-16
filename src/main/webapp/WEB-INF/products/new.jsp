<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.lang.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Products | New</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css" />
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<form:form action="new" method="post" modelAttribute="product">
		<p>
			<form:label path="name">Name:</form:label>
			<form:input path="name"/>
			<form:errors path="name"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:textarea path="description"/>
			<form:errors path="description"/>
		</p>
		<p>
			<form:label path="price">Price</form:label>
			<form:input type="number" step ="0.01" min="0" path="price"/>
			<form:errors path="price"/>
		</p>
		<p>
			<input type="submit" value="Create"/>
		</p>
	</form:form>
</body>
</html>
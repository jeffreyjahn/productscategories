<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.lang.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Category | Show</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css" />
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1><c:out value="${ category.getName() }"/></h1>
	<div class="products">
		<h3>Products:</h3>
		<ul>
			<c:forEach var="product" items="${ products }">
				<li><c:out value="${ product.name }"/></li>
			</c:forEach>
		</ul>
	</div>
	<form action="" method="post">
		<p>
			<select name="addProd">
				<c:forEach var="other" items="${ others }">
					<c:set var="name" value="${ other.getName() }"/>
					<option value="${ other.id }" label="${ name }"/>
				</c:forEach>
			</select>
		</p>
		<input type="submit" value="Add"/>
	</form>
	
</body>
</html>
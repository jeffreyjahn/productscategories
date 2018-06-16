<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.lang.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Products | Show</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css" />
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<c:out value="${ product.getName() }"/>
	<div class="categories">
		<h3>Categories:</h3>
		<ul>
			<c:forEach var="category" items="${ categories }">
				<li><c:out value="${ category.name }"/></li>
			</c:forEach>
		</ul>
	</div>
	<form action="" method="post">
		<p>
			<select name="addCat">
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
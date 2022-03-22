<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-8 offset-2">
				<h1 class="text-primary">
					Welcome,
					<c:out value="${loggedUser.userName}" />
					!
				</h1>
				<h5>This is your dashboard. Nothing to see here yet.</h5>
				<a href="/logout">Logout</a>
			</div>
		</div>
	</div>
</body>
</html>
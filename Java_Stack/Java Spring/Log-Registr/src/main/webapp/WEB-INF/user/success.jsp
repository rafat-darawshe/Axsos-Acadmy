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
	<div class="row mt-5">
		<div class="col-8 offset-2">
			<div class="row align-items-center">
				<div class="col">
					<h1 class="welcome">
						Welcome,
						<c:out value="${loggedUser.userName}" />
						!
					</h1>
					<p>Books from evereyone's shelves:</p>
				</div>
				<div class="col text-end">
					<div class="row">
						<div class="col">
							<a href="/logout">Logout</a>
						</div>

					</div>
					<div class="row">
						<div class="col">
							<a href="/books/new">+Add to my shelf!</a>
						</div>
					</div>
				</div>

			</div>
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Title</th>
						<th scope="col">Author Name</th>
						<th scope="col">Posted By</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${books}">
						<tr>

							<td><c:out value="${book.id}" /></td>
							<td><a href="/books/<c:out value="${book.id}"/>"><c:out
										value="${book.title}" /></a></td>
							<td><c:out value="${book.author}" /></td>
							<td><c:out value="${book.user.userName}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Edit <c:out value="${book.title}" /></title>
</head>
<body>
	<div class="container">

		<div class="row my-5">
			<div class="col-6 offset-3">
				<div class="row mb-5">
					<div class="col">
						<h3>Change your entry!</h3>

					</div>
					<div class="col text-end">
						<a href="/books">Back to the shelves</a>
					</div>
				</div>
				<div class="row">
					<div class="col text-start">
						<form:form action="/books/${book.id}" method="post"
							modelAttribute="book">
							<input type="hidden" name="_method" value="put">
							<div class="mb-3">
								<form:errors class="text-danger" path="title" />
								<form:input type="text" class="form-control" id="title"
									path="title" placeholder="Title" />
							</div>
							<div class="mb-3">
								<form:errors class="text-danger" path="author" />
								<form:input type="text" class="form-control" id="author"
									path="author" placeholder="Author" />
							</div>

							<div class="mb-3">
								<form:errors class="text-danger" path="thoughts" />
								<form:textarea class="form-control" id="thoughts"
									path="thoughts" placeholder="Add your thoughts" rows="3"></form:textarea>
							</div>
							<button type="submit" class="btn btn-primary float-end">Submit</button>
						</form:form>
					</div>
					<form:form action="/books/${book.id}" method="post" class="mt-5">
						<input type="hidden" name="_method" value="delete">
						<button type="submit" class="btn btn-primary">Delete Book!</button>
					</form:form>

				</div>
			</div>
		</div>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
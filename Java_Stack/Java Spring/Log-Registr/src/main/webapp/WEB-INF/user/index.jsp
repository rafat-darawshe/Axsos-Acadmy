<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>    
<!DOCTYPE html> 
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

    <title>Login-Registration</title>
</head>
<body>
    <div class="container-md-fluid border border-primary m-5 p-4 ">
    	<h1 style="margin-bottom:128px" class="text-center">Welcome </h1>
        <div class="row justify-content-evenly">
            <div class="col-4">
				<form:form class="row g-3 " method="post" action="/register" modelAttribute="newUser">
					<h2>Registration</h2>
                    <div class="form-floating mb-3 ">
                        <form:input type="text" class="form-control" id="floatingInput" placeholder="e.g. 10"
                            path="userName"/>
                        <label for="floatingInput">User Name</label>
                     	<form:errors path="userName" class="text-danger" />
                    </div>
                    <div class="form-floating">
                        <form:input type="email" class="form-control" id="floatingInput" placeholder="e.g. 10" path="email"/>
                        <label for="floatingInput">Email address</label>
                        <form:errors path="email" class="text-danger"/>
                    </div>
                    <div class="form-floating">
                        <form:input type="password" class="form-control" id="floatingInput" placeholder="e.g. 10"
                            path="password"/>
                        <label for="floatingInput">Password</label>
                        <form:errors path="password" class="text-danger" />
                    </div>
                    <div class="form-floating">
                        <form:input type="password" class="form-control" id="floatingInput" placeholder="e.g. 10"
                            path="confirm"/>
                        <label for="floatingInput">Confirm Password</label>
                        <form:errors path="confirm" class="text-danger" />
                    </div>
                    <div class="d-grid gap-2 col-6 mx-auto">
                        <form:button class="btn btn-primary" type="submit">Register</form:button>
                    </div>
                </form:form>
            </div>
            <div class="col-4">
                <form:form class="row g-3" method="post" action="/login" modelAttribute="newLogin">
                    <h2>Login</h2>
                    <div class="form-floating mb-3 ">
                    </div>
                    <div class="form-floating mb-3">
                        <form:input type="email" class="form-control" id="floatingInput" placeholder="e.g. 10" path="email"/>
                        <label for="floatingInput">Email address</label>
                        <form:errors path="email" class="text-danger"/>
                    </div>
                    <div class="form-floating">
                    	<label for="floatingInput">Password</label>
                        <form:input type="password" class="form-control" id="floatingInput" placeholder="e.g. 10" path="password"/>
                        <form:errors path="password" class="text-danger" />
                    </div>
                    <div class="d-grid gap-2 col-6 mx-auto">
                        <button class="btn btn-primary" type="submit">Login</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
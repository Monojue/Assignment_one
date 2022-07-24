<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
<title>Assignment One | Class Edit</title>
</head>
<body>

	<div class="container mt-3">
		<h3 class="">Add New Class for ${ course.name } </h3>

		<div class="row d-flex justify-content-center">

			<div class="col-4 card align-middle">
			
			<c:url var="save" value="/classes" >
				<c:param name="courseId" value="${ course.id }" ></c:param>
			</c:url>
			<form action="${ save }" method="post">
			
			<div class="mt-2">
				<label for="" class="form-label">Teacher</label>
				<input type="text" name="teacher" class="form-control" placeholder="Enter Teacher Name" required="required"/>
			</div>
			<div class="mt-2">
				<label for="" class="form-label">Enter Start Date</label>
				<input type="date" name="start_date" class="form-control" required="required"/>
			</div>
			<div class="mt-2 mb-2">
				<input type="submit" value="Submit" class="btn btn-primary" />
			</div>
			</form>
			
			

			</div>
		</div>

	</div>

</body>
</html>
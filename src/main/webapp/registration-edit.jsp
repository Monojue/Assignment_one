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
<title>Assignment One | Registration Edit</title>
</head>
<body>

	<div class="container mt-3">
		<h3>Add New Registration </h3>

		<div class="row d-flex justify-content-center">

			<div class="col-4 card">

				<c:url var="save" value="/registration">
					<c:param name="classId" value="${ openClass.id }"></c:param>
					<c:param name="courseId" value="${ course.id }"></c:param>
				</c:url>
				<form action="${ save }" method="post">

					<div class="mt-2">
						<label for="" class="form-label">Student Name</label> 
						<input type="text" name="name" placeholder="Enter Student Name" required="required" class="form-control" />
					</div>
					<div class="mt-2">
						<label for="" class="form-label">Phone Number</label> 
						<input type="tel" name="phone" placeholder="Enter Phone Number" required="required" class="form-control" />
					</div>
					<div class="mt-2">
						<label for="" class="form-label">Email</label> 
						<input type="email" name="email" placeholder="Enter Email" required="required" class="form-control" />
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
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
<title>Assignment One | Courses Edit</title>
</head>
<body>

	<div class="container mt-3">
		<h3>Add New Course</h3>

		<div class="row d-flex justify-content-center">

			<div class="col-4 card">

				<c:url var="save" value="/courses"></c:url>
				<form action="${ save }" method="post">

					<div class="mt-2">
						<label for="" class="form-label">Name</label> 
						<input type="text" name="name" placeholder="Enter Course Name" required="required" class="form-control" />
					</div>
					<div class="mt-2">
						<label for="" class="form-label">Duration</label> 
						<input type="number" name="duration" placeholder="Enter Course Duration" required="required" class="form-control" />
					</div>
					<div class="mt-2">
						<label for="" class="form-label">Fees</label> 
						<input type="number" name="fees" placeholder="Enter Course Fees" required="required" class="form-control" />
					</div>
					<div class="mt-2">
						<label for="" class="form-label">Description</label>
						<textarea rows="3" name="description" cols="40" class="form-control" placeholder="Enter Description"></textarea>
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
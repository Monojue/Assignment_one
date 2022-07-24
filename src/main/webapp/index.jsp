<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
<title>Assignment One | Courses</title>
</head>
<body>

	<div class="container mt-3">
		<h3>Courses</h3>
		<div>
			<a class="btn btn-primary" href="course-edit">Add New Course</a>
		</div>

		<div class="mt-4">

			<c:choose>
				<c:when test="${ empty courses }">
					<div class="alert alert-warning">There is NO COURSE!</div>
				</c:when>

			<c:otherwise>
				<table class="table table-striped">
				<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Duration</th>
							<th>Fees</th>
							<th>Description</th>
						</tr>
				</thead>
				
				<tbody>
					<c:forEach var="c" items="${ courses }">
						<tr>
							<td>${ c.id }</td>
							<td>${ c.name }</td>
							<td>${ c.duration } Months</td>
							<td>${ c.fees } Ks</td>
							<td>${ c.description }</td>
							<td>
								<c:url var="classes" value="/classes">
									<c:param name="courseId" value="${ c.id }"></c:param>
								</c:url>
								<a href="${ classes }">Open Classes</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				
				</table>
			</c:otherwise>

			</c:choose>

		</div>

	</div>

</body>
</html>
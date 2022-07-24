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
<title>Assignment One | Classes</title>
</head>
<body>

	<div class="container mt-3">
		<div class="row" >
			
			<div class="col">
			<h3>Classes for ${ course.name }</h3>
				<c:url var="addNew" value="/class-edit">
					<c:param name="courseId" value="${ course.id }"></c:param>
				</c:url>
				<a class="btn btn-primary" href="${ addNew }">Add New Class</a>
				
	
			</div>
		

		</div >

		<div class="mt-4 row">
		
			<div class="col-3" >
				<table class="table table-bordered mt-3" >
					<tbody>
						<tr>
							<th>Course Name</th>
							<td>${ course.name }</td>
						</tr>
						<tr>
							<th>Duration</th>
							<td>${ course.duration } Months</td>						
						</tr>
						<tr>
							<th>Fees</th>
							<td>${ course.fees } Ks</td>
						</tr>
						<tr>
							<th>Description</th>
							<td>${ course.description }</td>						
						</tr>
					</tbody>
				</table>
			</div>		

			<div class="col" >
			<c:choose>
				<c:when test="${ empty classes }">
					<div class="alert alert-warning">There is NO CLASS!</div>
				</c:when>
				<c:otherwise>
				
					<table class="table table-striped">
					
						<thead>
							<tr>
								<th>ID</th>		
								<th>Teacher</th>
								<th>Start Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${ classes }" >
								<tr>
									<td>${ c.id }</td>
									<td>${ c.teacher }</td>
									<td>${ c.startDate }</td>
									<c:url var="registration" value="/registration" >
									<c:param name="courseId" value="${ course.id }" ></c:param>
										<c:param name="classId" value="${ c.id }" ></c:param>
									</c:url>
									<td>
										<a href="${ registration }" >Class Registration</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						
					</table>
				
				</c:otherwise>
			</c:choose>			
			
			</div>

		</div>

	</div>

</body>
</html>
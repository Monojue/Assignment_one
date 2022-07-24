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
<title>Assignment One | Registration</title>
</head>
<body>

	<div class="container mt-3">
		<div class="row" >
			
			<div class="col">
			<h3>Registration for ${ course.name }</h3>
				<c:url var="addNew" value="/registration-edit">
					<c:param name="classId" value="${ openClass.id }"></c:param>
					<c:param name="courseId" value="${ course.id }" ></c:param>
				</c:url>
				<a class="btn btn-primary" href="${ addNew }">Add New Registration</a>
				
	
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
						<tr>
							<th>Teacher</th>
							<td>${ openClass.teacher }</td>						
						</tr>
						<tr>
							<th>Start Date</th>
							<td>${ openClass.startDate }</td>						
						</tr>
					</tbody>
				</table>
			</div>		

			<div class="col" >
			<c:choose>
				<c:when test="${ empty registration }">
					<div class="alert alert-warning">There is NO REGISTRATION!</div>
				</c:when>
				<c:otherwise>
				
					<table class="table table-striped">
					
						<thead>
							<tr>
								<th>ID</th>		
								<th>Student Name</th>
								<th>Phone</th>
								<th>Email</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="r" items="${ registration }" >
								<tr>
									<td>${ r.id }</td>
									<td>${ r.student }</td>
									<td>${ r.phone }</td>
									<td>${ r.email }</td>
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
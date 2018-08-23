<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
			integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/opne-iconic/1.1.1/font/css/open-iconic-bootstrap.min.css"/>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
Curi
<title>Organization Course</title>

</head>
<body>


	<div class="container" id="AddAssignment">
		<h1 class="display-4" align="center">Assignment Organizer</h1>
		<hr>
		<div class="row">
			<div class="col-sm">
				<p class="lead">Add Assignment</p>
				<hr></hr>
				<form method="post" action="AddAssignment">
					<table>
						<tr>
							<td>Course :</td>
						</tr>
						<tr>
							<td><select class="form-control" name="cid" id="selectCourse">
									<c:forEach var="centry" items="${centry}">

										<option value="${centry.cid}">${centry.cnumber}-${centry.cname}</option>

									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td>Assignment Discription :</td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" name="assiDesc"
								value="${param.assiDesc}"
								placeholder="Enter assignment description"></input><br /></td>
						</tr>
						<tr>
							<td><input type="submit" class="btn btn-primary"
								value="Add Assignmnet" /></td>
						</tr>
					</table>
				</form>
			</div>



			<div class="col-sm" id="AddController">
				<p class="lead">Add Course</p>
				<hr></hr>
				<form action="AddController" method="post">
					<table>
						<tr>
							<td>Course Number:</td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" name="cnumber"
								value="${param.cnumber}" placeholder="Ex. CS3220" /> <br /></td>
						</tr>
						<tr>
							<td>Course Name :</td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" name="cname"
								value="${param.cname}"
								placeholder="Ex. Web and Internet Program"></input><br /></td>
						</tr>
						<tr>
							<td><input type="submit" class="btn btn-primary"
								value="Add Course" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<hr>
		<form action="DeleteCourse" method="post">
			<div class="row">
				<div class="card">
					<div class="card-header">
						<c:forEach var="centry" items="${centry}">
							<h5 class="card-title">
								<span>${centry.cnumber}</span>&nbsp;&nbsp;&nbsp; 
								<a
									href="DeleteCourse?cid=${centry.cid}"> Delete 
									<span class="oi oi-trash float-right"></span>
								</a>
							</h5>
							<h6 class="card-subtitle mb-2 text-muted">
								<code>${centry.cname}</code>
							</h6>
						
					
						<div class="card-body">
							<ul class="list-group list-group-flush">
								<li class="list-group-item">
									<c:forEach items="${aentry}" var="aentry">
										<c:if test="${aentry.cid==centry.cid}">
											<p>
												<c:choose>
													<c:when test="${aentry.flag == 0 }">
														<a href="updateassignment?aid=${aentry.aid}"&flag=1> ${aentry.assiDesc } <span
															class="oi oi-trash float-right"></span>
														</a>
														<a href="DeleteAssignment?aid=${aentry.aid}"> Delete <span
															class="oi oi-trash float-right"></span>
														</a>
													</c:when>
													<c:otherwise>
														<c:when test="${aentry.flag == 0 }">
															<a href="updateassignment?aid=${aentry.aid}"&flag=0> ${aentry.assiDesc } <span
																class="oi oi-trash float-right"></span>
															</a>
															<a href="DeleteAssignment?aid=${aentry.aid}"> Delete <span
																class="oi oi-trash float-right"></span>
															</a>
													</c:when>
													</c:otherwise>
												</c:choose>
											</p>
										</c:if>
									</c:forEach>
								</li>
							</ul>
						</div>
					  </div>
					</c:forEach>
				</div>
			</div>
		</form>
			<a href="Archive" class="btn btn-primary">Archive Completed
		Assignment</a>
	</div>
</body>
</html>
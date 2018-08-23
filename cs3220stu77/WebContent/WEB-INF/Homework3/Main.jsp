<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   
  <jsp:useBean id="cb" class="Models.CustomerBean" scope="application" />
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
</head>
<body>

	<form action="Search" method=post>
        Search : <input type=text name="search">
        <input type="hidden" name="search" value="search" />
        <input
            type="submit" name="search" value="search" />
        </form>
       
	
	<table border="1">
		<tr><th>ID</th><th>NAME</th><th>ADDRESS</th><th>EMAIL</th><TH>PHONE</TH><th>GENDER</th><th>OPPORTUNITIES_NAME</th><th>ACCOUNT</th><th colspan="2">Operations</th></tr>
		<c:forEach items="${entries}" var="entry" varStatus="status">
			<tr>
			  <td>${entry.id}</td>
			  <td>
			  	<c:out value="${entry.name}"></c:out>
			  </td>
			  <td>${entry.address}</td>
			  <td>${entry.email}</td>
			  <td>${entry.phone}</td>
			  <td>${entry.gender}</td>
			  <td>${entry.opportunity_name}</td>
			  <td>${entry.account}</td>
			  <!--  <td>${entry.date}</td>-->
			  
			  <td><a href="EditCustomer?id=${entry.id}">Edit</a></td>
			  <td><a href="DeleteCustomer?id=${entry.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

<p><a href="AddCustomer">Add Customer</a></p>
</body>
</html>
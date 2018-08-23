<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${empty entry}"> 
	<c:redirect url="Main"></c:redirect>
</c:if>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>
	<form method="post">
		<input type="hidden" name="id" value="${entry.id}"/>
		Name: <input type="text" name="name" value="${entry.name}" placeholder="Enter your name:"/> <br />
		Address : <textarea name="address" >${entry.address}"</textarea> <br />
		Email : <input type="text" name="email" value="${entry.email}" placeholder="Enter your email"/><br/>
		Phone : <input type="text" name="phone" value="${entry.phone}" placeholder="Enter your phone"/><br/>
		Gender : <input type="text" name="gender" value="${entry.gender}" placeholder="Enter your gender"/><br/>
		Opportunity Name : <input type="text" name="opportunity_name" value="${entry.opportunity_name}" placeholder="Enter your opportunity name"/><br/>
		Account : <input type="text" name="account" value="${entry.account}" placeholder="Enter your account"/><br/>
		
		<input type="submit" name="save" value="Save" />
	</form>

</body>
</html>
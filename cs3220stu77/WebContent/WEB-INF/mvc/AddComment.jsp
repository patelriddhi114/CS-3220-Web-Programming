<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Comment</title>
</head>
<body>
	<form method="post">
	
		<c:if test="${not empty nameError}"> 
			<p>${nameError}</p>	
		</c:if>
		
		Name: <input type="text" name="name" value="${param.name}" placehoder="Enter your name:"/> <br />
		
		<c:if test="${not empty messageError}"> 
			<p>${messageError}</p>	
		</c:if>
		
		Message : <textarea name="message" value="${param.message}" placeholder="Enter the message"></textarea> <br /> 
		<input type="submit" value="Save" />
	</form>
</body>
</html>
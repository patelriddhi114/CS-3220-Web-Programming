<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${not empty param.login}">
	<c:if test="${param.username == 'riddhi' and param['password'] == 'abcd' }">
		<c:set var="user" value="${param.username}" scope="session"></c:set>
		<c:redirect url="member.jsp"></c:redirect>
	</c:if>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="Login.jsp" method="post">
		Username : <input type="text" name="username"/><br/>
		Password : <input type="text" name="password"/><br/>
		<input type="submit" name="login" value="Login"/><br/>
	</form>
</body>
</html>
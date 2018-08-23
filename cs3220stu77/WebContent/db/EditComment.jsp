<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- set data source --%>
<sql:setDataSource driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu77" user="cs3220stu77"
	password="D!SAZPAB" />

<c:if test="${not empty param.add}">
	<sql:update>
		update guestbook set name = name,message=message where id = id;
    	<!--  insert into guestbook (name, message) values (?, ?)-->
    	<sql:param value="${param.name}" />
		<sql:param value="${param.message}" />
		<sql:param value="${param.id }"></sql:param>
	</sql:update>
	<c:redirect url="GuestBook.jsp" />
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Comment</title>
</head>
<body>
	<form action="EditComment.jsp" method="post">
		Name: <input type="text" name="name" /> <br /> 
		Message: <input type="text" name="message" /> <br /> 
		<input type="submit" name="add" value="Add" />
	</form>
</body>
</html>
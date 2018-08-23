<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%-- set data source --%>
<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu77"
	user="cs3220stu77"
	password="D!SAZPAB"/>

<%-- query --%>
<sql:query var="results" sql="SELECT * FROM items"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>JSTL SQL Example 2</TITLE> </HEAD>

<table>
  <c:forEach items="${results.rowsByIndex}" var="row">
	  <tr>
	    <c:forEach items="${row}" var="col">
	        <td>${col}</td>
	    </c:forEach>
	  </tr>
  </c:forEach>
</table>
    
</BODY>
</HTML>

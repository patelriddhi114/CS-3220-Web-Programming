<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean class="bean.BGBeaan" id="bg"></jsp:useBean>
    
    <!--<jsp:setProperty property="r" name="bg" param="Red"/>
	<jsp:setProperty property="g" name="bg" param="Green"/>
	<jsp:setProperty property="b" name="bg" param="Blue"/>
	
	OR
	-->
	<jsp:setProperty property="*" name="bg" />
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Backgorund Bean</title>

	<style>
		body{
			background-color : rgb(
									<jsp:getProperty property="r" name="bg"/>,
									<jsp:getProperty property="g" name="bg"/>,
									<jsp:getProperty property="b" name="bg"/>
								  );
		}
  	</style>
</head>
<body>

<h3>
R:<jsp:getProperty property="r" name="bg"/><br>
G:<jsp:getProperty property="g" name="bg"/><br>
B:<jsp:getProperty property="b" name="bg"/><br>
</h3>

	<form action="BackgroundBean.jsp" method="get">
	
		<!-- 
			<input type="text" name="Red" placeholder="Enter red value"><br>
		<input type="text" name="Green" placeholder="Enter green value"><br>
		<input type="text" name="Blue" placeholder="Enter blue value"><br>
		
		 -->
	
		
		<input type="text" name="r" placeholder="Enter red value"><br>
		<input type="text" name="g" placeholder="Enter green value"><br>
		<input type="text" name="b" placeholder="Enter blue value"><br>
		
		<input type="submit" value="Change Backgound color"><br>
	</form>

</body>
</html>
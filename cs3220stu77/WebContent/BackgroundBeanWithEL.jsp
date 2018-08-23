<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean class="bean.BGBeaan" id="bg" scope="session"></jsp:useBean>
    
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
									${ bg.r},
									${ bg.g},
									${ bg.b}
								  );
		}
  	</style>
</head>
<body>

<h3>
R:${ bg.r }</br>
G:${ bg.g }</br>
B:${ bg.b }</br>
</h3>

	<form action="BackgroundBeanWithEL.jsp" method="get">
	
		<!-- 
			<input type="text" name="Red" placeholder="Enter red value"><br>
		<input type="text" name="Green" placeholder="Enter green value"><br>
		<input type="text" name="Blue" placeholder="Enter blue value"><br>
		
		 -->
	
		
		<input type="text" name="r" value="${ bg.r }" placeholder="Enter red value"><br>
		<input type="text" name="g" value="${ bg.g }" placeholder="Enter green value"><br>
		<input type="text" name="b" value="${ bg.b }" placeholder="Enter blue value"><br>
		
		<input type="submit" value="Change Backgound color"><br>
	</form>

</body>
</html>
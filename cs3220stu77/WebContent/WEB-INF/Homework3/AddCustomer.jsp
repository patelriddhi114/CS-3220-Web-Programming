<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
	<form method="post">
	
		<c:if test="${not empty nameError}"> 
			<p>${nameError}</p>	
		</c:if>
		Name: <input type="text" name="name" value="${param.name}" placehoder="Enter your name:"/> <br />
		
		<c:if test="${not empty addressError}"> 
			<p>${addressError}</p>	
		</c:if>
		Address : <textarea name="address" value="${param.address}" placeholder="Enter the Address"></textarea> <br /> 
		
		<c:if test="${not empty emailError}"> 
			<p>${emailError}</p>	
		</c:if>
		Email : <input type="text" name="email" value="${param.email}" placeholder="Enter the Email"></input> <br /> 
		
		<c:if test="${not empty phoneError}"> 
			<p>${phoneError}</p>	
		</c:if>
		Phone: <input type="text" name="phone" value="${param.phone}" placehoder="Enter your phone:"/> <br /><br/>
		
		<c:if test="${not empty genderError}"> 
			<p>${genderError}</p>	
		</c:if>
		Gender: <input type="text" name="gender" value="${param.gender}" placehoder="Enter your gender"/> <br />
		
		<c:if test="${not empty oppo_nameError}"> 
			<p>${oppo_nameError}</p>	
		</c:if>
		Opportunity Name : <input type="text" name="opportunity_name" value="${param.opportunity_name}" placehoder="Enter your opportunity name:"/> <br />
		
		<c:if test="${not empty accountError}"> 
			<p>${accountError}</p>	
		</c:if>
		Account Name : <input type="text" name="account" value="${param.account}" placehoder="Enter your account:"/> <br />
		
		<input type="submit" value="Save" />
	</form>
</body>
</html>
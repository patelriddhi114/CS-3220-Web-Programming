<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL Expression</title>
</head>
<body>
	
<table class="table table-bordered table-striped table-hover">
	<tr>
		<td colspan="2"><b>Arithmetic Operators</b></td>
		<td colspan="2"><b>Relational Operators</b></td>
	</tr>
	<tr>
		<td align="center"><b>Expression</b></td>
		<td align="center"><b>Result</b></td>
		<td align="center"><b>Expression</b></td>
		<td align="center"><b>Result</b></td>
	</tr>
	<tr>
		<td align="center">\${3+2-1}</td>
		<td align="center">${3+2-1}</td>
		<td align="center">\$(1<2)</td>
		<td align="center">${1 lt 2}</td>
	</tr>
	
	<tr>
		<td align="center">\${"1"+2}</td>
		<td align="center">${"1"+2}</td>
		<td align="center">\$("a"<"b")</td>
		<td align="center">${"a" lt "b"}</td>
	</tr>
	
	<tr>
		<td align="center">\${1+2*3+3/4}</td>
		<td align="center">${1+2*3+3/4 }</td>
		<td align="center">\$(2/3>=3/2)</td>
		<td align="center">${2/3 ge 3/2}</td>
	</tr>
	
	<tr>
		<td align="center">\${3%2}</td>
		<td align="center">${3%2}</td>
		<td align="center">\${3/4==0.75}</td>
		<td align="center">${3/4 eq 0.75}</td>
	</tr>
	
	<tr>
		<td align="center">\${{8 div 2}mod3}</td>
		<td align="center">${(8/2)mod 3}</td>
		<td align="center">\${null=="test"}</td>
		<td align="center">${null eq "test"}</td>
	</tr>
	
	<tr>
		<td colspan="2"><b>Logical Operators</b></td>
		<td colspan="2"><b>empty Operators</b></td>
	</tr>
	<tr>
		<td align="center"><b>Expression</b></td>
		<td align="center"><b>Result</b></td>
		<td align="center"><b>Expression</b></td>
		<td align="center"><b>Result</b></td>
	</tr>
	<tr>
		<td align="center">\${(1<2)&&(4<3)}</td>
		<td align="center">${(1 lt 2)&&(4 lt 3)}</td>
		<td align="center">\${empty ""}</td>
		<td align="center">${empty ""}</td>
	</tr>
	
	<tr>
		<td align="center">\${(1<2)||(4<3)}</td>
		<td align="center">${(1 lt 2)||(4 lt 3)}</td>
		<td align="center">\${empty null}</td>
		<td align="center">${empty null}</td>
	</tr>
	
	<tr>
		<td align="center">\${!(1<2)}</td>
		<td align="center">${not(1 lt 2)}</td>
		<td align="center">\$s{empty param.blah}</td>
		<td align="center">${empty param.blah}</td>
	</tr>

</table>

</body>
</html>
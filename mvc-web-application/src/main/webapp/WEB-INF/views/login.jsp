<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yahoo!!!!! from JSP</title>
</head>
<body>
 
 Enter you credentials  
 
	 <form action="/login" method="post">
	 	<p> <font color="red"> ${errorMessage} </font></p> 
	 	User Name <input type="text" name="name"> <br>
	 	Password  <input type="password" name="password"> <br>
	 	<input type="Submit" value="Login">
	 </form>
	  
</body>
</html>
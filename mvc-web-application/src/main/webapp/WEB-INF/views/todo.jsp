<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<br /> Hi ${name} @ ${password}, Add your new Todo item here <br />
		<br />

		<form:form method="post" commandName="todo">

			<form:hidden path="id" />
			<%-- <form:hidden path="user" /> --%>
			
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
				<form:input path="desc" type="text" class="form-control"
					required="required"></form:input>
				<form:errors path="desc" cssClass="test-warning"></form:errors>
			</fieldset>
            <fieldset class="form-group">
                <form:label path="targetDate">Target Date</form:label>
                <form:input path="targetDate" type="text" class="form-control"
                    required="required" />
                <form:errors path="targetDate" cssClass="text-warning" />
            </fieldset>
			<input class="btn btn-success" type="submit" value="submit" />
		</form:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
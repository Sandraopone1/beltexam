<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit ${course.name}</h1>
	
	<form:form method="post" action="/courses/${course.id}/edit" modelAttribute="course">
		<form:label path="name"> Name:
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</form:label><br>
		
		<form:label path="instructor"> Instructor:
			<form:errors path="instructor"></form:errors>
			<form:input path="instructor"></form:input>
		</form:label><br>
		
		<form:label path="courseLimit">Limit:
			<form:errors path="courseLimit"></form:errors>
			<form:input type="number" path="courseLimit"></form:input>
		</form:label><br><br>
		
		<input type="submit" value="Update"/><br><br>
	</form:form><br>
	
	<a href ="/courses">Back to Courses</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	</head>

	<h1>Create a new Course</h1>

		<form:form action="/courses/new" method="POST" modelAttribute="course">
			<form:label path="name">Name:
				<form:errors path="name"></form:errors>
				<form:input path="name"></form:input>
			</form:label>

			<form:label path="instructor"> Instructor:
			<form:errors path="instructor"></form:errors>
			<form:input path="instructor"></form:input>
		</form:label><br>


			<form:label path="courseLimit">Limit:
			<form:errors path="courseLimit"></form:errors>
			<form:input type="number" path="courseLimit"></form:input>
		</form:label><br><br>

			<input type="submit" value="Create "/><br><br>
				<a href ="/courses">Back to courses</a>
		</form:form>
	</body>
</html>
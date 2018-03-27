<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Course</title>
</head>
<body>

	<h1>${course.name}</h1>
	
	<p>Instructor: ${course.instructor}</p>
	<p>Sign Ups: ${course.signUp}</p>
	
	 <table border="1">
    		<tr>
    			<th>Name</th>
    			<th>Sign Up Date</th>
    			<th>Action</th>
    		</tr>
    		<c:forEach items="${course.users}" var="user">
    		<tr>
    			<td>${user.name}</td>
    			<td>${user.updatedAt}</td>
    			<td>${user.updatedAt}</td>
    		</tr>
    		</c:forEach>
    </table><br><br>
    
    <a href="/courses/${id}/edit">Edit</a><br><br>
    <a href="/courses/${id}/destroy">Delete</a><br><br>
    
    <a href="/">Back to Courses</a>
</body>
</html>
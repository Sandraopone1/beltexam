<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
    <h1>Welcome <c:out value="${currentUser.name}"></c:out>!</h1>
    
    <h2>Courses:</h2>
   <table border="1">

    		<tr>
    			<th>Course</th>
    			<th>Instructor</th>
    			<th>SignUps</th>
    			<th>Action</th>
    		</tr>
    		<c:forEach items="${courses}" var="course">
    		<tr>
    			<td><a href="/courses/${course.id}">${course.name}</a></td>
    			<td>${course.instructor}</td>
    			<td>${course.signUp} / ${course.courseLimit}</td>
    			<c:if test="${course.signUp == course.courseLimit}">
    				<td>Full</td>
    			</c:if>
    			<c:if test="${course.signUp != course.courseLimit}">
    				<td><a href="/courses/${course.id}/signup">Add</a></td>
    			</c:if>
    			
    			
    				
    		</tr>
    		</c:forEach>
    </table><br><br>
    <a href = "/courses/new">Add a Course</a><br><br>
    
    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>
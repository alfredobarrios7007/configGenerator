<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hey hey my my
	
	
<c:forEach var="obj" items="${objs}">

		<h1>${obj.getKey()}</h1>
		<h1>${obj.getValue()}</h1>
	
</c:forEach>
	
	
</body>
</html>
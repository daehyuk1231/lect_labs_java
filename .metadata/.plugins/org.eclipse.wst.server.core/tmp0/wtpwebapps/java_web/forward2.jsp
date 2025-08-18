<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Action Tag</h3>
	<jsp:forward page='<%=request.getParameter("url")%>'>
		<jsp:param value='<%=request.getParameter("name")%>' name="name" />
	</jsp:forward>
</body>
</html>
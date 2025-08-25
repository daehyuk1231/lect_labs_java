<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>에러페이지</h1>
	<p>처리중 오류가 발생되었습니다. 담당자에게 문의하세요.</p>
	<!-- 
	URL: ${url }
	Exception: ${exceptoin.message }
	<c:forEach items="${exception.stackTrace}" var="ste">    ${ste} 
    </c:forEach>
	 -->
</body>
</html>
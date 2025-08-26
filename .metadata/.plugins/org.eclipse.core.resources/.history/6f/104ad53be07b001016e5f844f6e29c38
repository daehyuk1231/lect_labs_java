<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
	02. 액션 tag
	  - forward, include, usebean
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
include 지시자: <%@include file="./include.jsp" %>
<%-- jsp 코드를 지정된 자리에 삽입된다. --%>

include 액션태그:
<jsp:include page="./include.jsp" flush="false">
<jsp:param value="액션태그" name="msg"/>
</jsp:include>
<%-- 제어가 인쿨루드된 jsp로 넘어갔다가 온다. --%>

<form name="frmForm" method="post" action="./forward2.jsp">
        <input type="text" name="name">
        <input type="hidden" name="url" value="./forward3.jsp">
        <button type="submit"> 전송 </button>
    </form>
</body>
</html>
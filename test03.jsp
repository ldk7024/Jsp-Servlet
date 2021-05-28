<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%for (int i=1; i<=5; i++){ %>
<font size ="<%=i%>">야호~</font><br>
<%} %>
<c:forEach var="i" begin ="1" end ="5" step ="1">
<font size="${i }">야호~</font><br>
</c:forEach>
</body>
</html>
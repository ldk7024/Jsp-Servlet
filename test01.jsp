<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	// 메서드
	public int hap(int a,int b){
		return a+b;
	
    }
%>    
    <% 
      int cnt = hap(10,10); // call
      
      %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML 주석문 -->
<%--JSP 주석문 --%>
<%=cnt %>

</body>
</html>
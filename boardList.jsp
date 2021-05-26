<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kr.smhrd.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
 List<BoardVO> list = (List<BoardVO>)request.getAttribute("list"); //다운캐스팅
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 1>
   <tr>
      <td>번호</td>
      <td>제목</td>
      <td>조회수</td>
      <td>작성자</td>
      <td>작성일</td>
   </tr>
   <% for(BoardVO vo: list){ %>
    <tr>
       <td><%=vo.getIdx() %></td>
       <td><%=vo.getTitle() %></td>
       <td><%=vo.getCount() %></td>
       <td><%=vo.getWriter() %></td>
       <td><%=vo.getIndate() %></td>
    </tr>
    <%} %>
</table>
</body>
</html>
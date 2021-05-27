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
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript"> //자바 스크립트 
  function delFn(idx) { //함수만들기(삭제)    
   //alert("DEL"); //삭제를 눌렀을때 경고창
    location.href = "/MVC01/delete.do?idx="+idx;
}
  function registerFn(writer) {
   location.href = "/MVC01/registerForm.do";
} 
  </script>
</head>
<body>

<div class="container">
  <h2>Main화면</h2>
  <div class="panel panel-default">
    <div class="panel-heading">로그인</div>
    <div class="panel-body">
    <table class="table table-bordered table-hover">
   <tr>
      <td>번호</td>
      <td>제목</td>
      <td>조회수</td>
      <td>작성자</td>
      <td>작성일</td>
      <td>삭제</td>
   </tr>
   <% for(BoardVO vo: list){ %>
    <tr>
       <td><%=vo.getIdx() %></td>
       <td><a href="/MVC01/content.do?idx=<%=vo.getIdx() %>"><%=vo.getTitle() %></a></td>
       <td><%=vo.getCount() %></td>
       <td><%=vo.getWriter() %></td>
       <td><%=vo.getIndate() %></td>
       <td><input type = "button" onclick="delFn(<%=vo.getIdx() %>)" value="삭제" class="btn "></td>
    </tr>
    <%} %>
    <tr>
       <td colspan="6">
          <input type="button" value = "글쓰기" onclick="registerFn()" class="btn btn-primary btn-lg">
       </td>
    </tr>
</table>
    </div>
    <div class="panel-footer">빅데이터 4차(이대교))</div>
  </div>
</div>

</body>
</html>
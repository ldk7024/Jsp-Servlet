<%@page import="kr.smhrd.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	BoardVO vo = (BoardVO)request.getAttribute("vo");
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
  <script type="text/javascript">
  function goList() {
	  location.href ="/MVC01/list.do"
	
}
  
  
  </script>
</head>
<body>
<div class="container">
  <h2>게시판 상세보기</h2>
  <div class="panel panel-default">
    <div class="panel-heading">로그인 화면</div>
    <div class ="panel-body">
    <form class="form-horizontal" action="/MVC01/update.do" method ="post">
  <div class="form-group">
    <label class="control-label col-sm-2" >번호:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" name="idx" value="<%=vo.getIdx() %>" readonly="readonly">
    </div>
    </div>
  <div class="form-group">
    <label class="control-label col-sm-2">제목:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="title" value="<%=vo.getTitle() %>">
    </div>
  </div>
    
   <div class="form-group">
    <label class="control-label col-sm-2">내용:</label>
    <div class="col-sm-10">
      <textarea row ="8" cols="60" class ="form-control" name ="contents"><%=vo.getContents() %></textarea>
    </div>
    </div>
      <div class="form-group">
    <label class="control-label col-sm-2">작성자:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" value="<%=vo.getWriter()%>" readonly ="readonly">
    	</div>
    </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary btn-sm">수정</button>
      <button type="reset" class="btn btn-warning btn-sm">취소</button>
      <button type="button" class="btn btn-success btn-sm" onclick ="goList">목록</button>
    </div>
  </div>

</form>
    
    </div>
    <div class="panel-footer">빅데이터 분석서비스 개발자과정 4차 (이대교)</div>
  </div>
</div>


</body>
</html>
<%@page import="kr.smhrd.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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

</head>
<body>

  <div class="panel panel-default">
    <div class="panel-heading">게시판 상세보기</div>
    <div class ="panel-body">
    <form class="form-horizontal" action="<c:url value ='/update.do'/>" method ="post">
  <div class="form-group">
    <label class="control-label col-sm-2" >번호:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" name="idx" value="${vo.idx}" readonly="readonly">
    
    </div>
    </div>
  <div class="form-group">
    <label class="control-label col-sm-2">제목:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="title" value="${vo.title}">
    </div>
  </div>
    
   <div class="form-group">
    <label class="control-label col-sm-2">내용:</label>
    <div class="col-sm-10">
      <textarea row ="8" cols="60" class ="form-control" name ="contents">${vo.contents}</textarea>
    </div>
    </div>
      <div class="form-group">
    <label class="control-label col-sm-2">작성자:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" value="${vo.writer}" readonly ="readonly">
    	</div>
    </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary btn-sm">수정</button>
      <button type="reset" class="btn btn-warning btn-sm">취소</button>
      <button type="button" class="btn btn-success btn-sm" onclick ="goList()">목록</button>
    </div>
  </div>

</form>
    
    </div>
  </div>
</div>


</body>
</html>
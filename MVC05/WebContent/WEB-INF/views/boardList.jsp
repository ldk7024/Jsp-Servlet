<%@page import="kr.smhrd.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		$(document).ready(()=>{
			<c:if test="${ !empty sessionScope.msg }">
				alert("${sessionScope.msg}");
				<c:remove var="msg"/>
			</c:if>
			
		});
	
	
		function delFn(idx){
			//alert("DEL");	
			location.href="<c:url value='/delete.do'/>?idx="+idx;
		}
		function registerFn(){	
			location.href="<c:url value='/registerForm.do'/>"; // 게시판 글쓰기
		}
		function out(){
			location.href="<c:url value='/logout.do'/>";
			
		}
	</script>



</head>
<body>

<div class="container">
  <h2>메인화면</h2>
  <div class="panel panel-default">
  	<div class="panel-heading">
  	
  	<c:if test="${sessionScope.userVO==null}">	
  		<form class="form-inline" action="<c:url value='/login.do'/>" method="post">
 			<div class="form-group">
    			<label>ID:</label>
    			<input type="text" class="form-control" id="user_id" name="user_id">
  			</div>
  			<div class="form-group">
    			<label>PWD:</label>
    			<input type="password" class="form-control" id="password" name="password">
  			</div> 
  			<button type="submit" class="btn btn-info">로그인</button>
		</form>
	</c:if>
	
	<c:if test="${sessionScope.userVO!=null}">	
		${sessionScope.userVO.user_name}님 환영합니다.
		<button type="button" class="btn btn-info" onclick="out()">로그아웃</button>
	</c:if>
	
  	</div>
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
		<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.idx}</td>
			<td><a href="<c:url value='/content.do'/>?idx=${vo.idx}">${vo.title}</a></td>
			<td>${vo.count}</td>
			<td>${vo.writer}</td>
			<td>${vo.indate}</td>
			<c:if test="${sessionScope.userVO==null || sessionScope.userVO.user_name!=vo.writer}">
			<td><input type = "button" onclick="delFn(${vo.idx})" value = "삭제" class='btn btn-primary btn-sm' disabled="disabled"></td>
			</c:if>
			
			<c:if test="${sessionScope.userVO!=null && sessionScope.userVO.user_name==vo.writer}">
			<td><input type = "button" onclick="delFn(${vo.idx})" value = "삭제" class='btn btn-primary btn-sm'></td>
			</c:if>
		</tr>		
		</c:forEach>
		
		<tr>
			<td colspan=6 align="right">
				<c:if test="${!empty sessionScope.userVO}">
				<input type = "button" onclick="registerFn()" value = "글쓰기" class='btn btn-success btn-sm'>
				</c:if>
			</td>	
		</tr>
	</table>
    
    
    </div>
    <div class="panel-footer">빅데이터 분석서비스 개발자과정 4차(안은식)</div>
  </div>
</div>

	
</body>
</html>
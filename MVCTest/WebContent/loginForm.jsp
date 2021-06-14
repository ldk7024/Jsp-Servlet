<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC TEST</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(()=>{
	list();
   
});
function loginFn(){
	var user_id=$("#user_id").val();
	var password=$("#password").val();
	$.ajax({
		url : "logincheck.go",
		type : "post",
		data : {"user_id" : user_id, "password" : password},
		success : function(data){ 
			//alert(data);
			if(data=="NO"){
				alert("로그인에 실패했습니다.");
			}else{
				alert(user_id+"님 방문을 환영합니다!!!");
			} 		
		},
		error : function(){ alert("error");}				
	});
	
}
function logoutFn(){
	$.ajax({
		url : "logoutCheck.go",
		type : "get",
		success : function(){
			location.href="loginForm.jsp";
		},
		error : function(){ alert("error"); }	
	});
}
</script>
</head>
<body>
	<div class="container">
		<h4>빅데이터 분석 서비스 과정</h4>
		<div class="panel panel-default">
			<div class="panel-heading">

				<c:if test="${sessionScope.userVO==null}">
					<!-- sessionScope. or requestScope -->
					<form id="loginfrm" class="form-inline" method="post">
						<div class="form-group">
							<label>ID:</label> <input type="text" class="form-control"
								id="user_id" name="user_id">
						</div>
						<div class="form-group">
							<label>PWD:</label> <input type="password" class="form-control"
								id="password" name="password">
						</div>
						<button type="submit" class="btn btn-info" onclick="loginFn()">로그인</button>
					</form>
				</c:if>

				<c:if test="${sessionScope.LoginVO!=null}">
    			   ${sessionScope.userVO.user_name}님 방문을 환영합니다.
    			<input type="button" value="로그아웃" onclick="logoutFn()"
						class="btn btn-info btn-sm">
				</c:if>





			</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   $("#btn").click(()=>{
       list();
   });
});
   function list(){
	   $.ajax({
		   url: "ajaxlist.do", //------------------>AjaxBoardListController --
		   type: "get",       //                                             ↓ JSON, list==dic:{"idx":1, "name":"홍길동"}
		   success: callback, //<---------------------------------------------
		   dataType: "json",
		   error: function(){alert("error")}
		   
	   });
   }
   

function callback(data){
	// alert(data);
	var view = "<table class ='table table-bordered table-hover'>";
	view+="<tr>";
	view+="<td>번호</td>";
	view+="<td>제목</td>";
	view+="<td>조회수</td>";
	view+="<td>작성자</td>";
	view+="<td>작성일</td>";
	view+="<td>삭제</td>";
	view+="</tr>";
	$.each(data,(index,obj)=>{ 
		
		view+="<tr>";
			view+="<td>"+obj.idx+"</td>";
			view+="<td>"+obj.title+"</td>";
			view+="<td>"+obj.count+"</td>";
			view+="<td>"+obj.writer+"</td>";
			view+="<td>"+obj.indate+"</td>";
			view+="<td><button class ='btn btn-warning' onclick='delBtn("+obj.idx+")'>삭제</button></td>";
			view+="</tr>"
	});
	view+="</table>";
	$("#msg").html(view);
}
function delBtn(idx){
	$.ajax({
		url: "ajaxdelete.do",
		type:"get",
		data: {"idx": idx},
		success: list,
		error: function(){ alert("error"); }
	});
}
</script>
</head>
<body>
<input type = "button" value="게시판리스트 가져오기" id= "btn" class ="btn btn-info">
<div id = "msg">여기에 게시판 리스트를 출력하시오</div>
</body>
</html>
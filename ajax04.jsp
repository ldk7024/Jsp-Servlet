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
   $("#btn").click(()=>{
       list();
   });
}); 
function list() {     //list를 호출하기위해 함수에 담아줌
      $("#bf").css("display", "none");
      $.ajax({
         url : "ajaxlist.do", //서버로요청 -> AjaxBoardlistController---↓
         type : "get",       //           
         //data : {"msg":msg},
         datatype : "json", //  JSON=dic : {"idx":1, "name" : "홍길동"} 
         success : callback, //콜백함수
         error : function() {alert("error");}         
      });
}
   

function callback(data) {
   //alert(data);
   var view="<table class='table table-bordered table-hover'>";
   view+="<tr>"; //동적으로 붙히기때문에 여기서부터는 +를 붙힘
   view+="<td>번호</td>";
   view+="<td>제목</td>";
   view+="<td>조회수</td>";
   view+="<td>작성자</td>";
   view+="<td>작성일</td>";
   view+="<td><button>삭제</button></td>";
   
   view+="</tr>";
   $.each(data, (index, obj)=>{ 
      view+="<tr>"; //동적으로 붙히기때문에 여기서부터는 +를 붙힘
      view+="<td id='idx"+index+"'>"+obj.idx+"</td>";
      view+="<td><a href='javascript:contentFn("+index+")'>"+obj.title+"</a></td>";//"+obj.idx+"
      view+="<td>"+obj.count+"</td>";
      view+="<td>"+obj.writer+"</td>";
      view+="<td>"+obj.indate+"</td>";
      view+="<td><button class='btn btn-primary' onclick='delbtn("+obj.idx+")'>삭제</button></td>";
      view+="</tr>";   
      
   });   
    view+="<tr>";
    view+="<td colspan='6'>";
    view+="<input type='button' value='글쓰기' class='btn btn-info' onclick='btnWrite()'/>"; 
    view+="</td>";
    view+="</tr>";
   view+="</table>";
   $("#msg").html(view);
}
function contentFn(index) {
   var idx=$("#idx"+index).text();  //obj.idx 즉 선택한 컨텐츠 아이디 숫자를 가지고와야함!. alert(idx);
$.ajax({
     url : "ajaxcontent.do",
     type : "get",
     
     data : {"idx" : idx},
     datatype : "json",
     success : callContent, //콜백
     error : function () {alert("error");}         
});
   
}
function callContent(data) {  //위에 callContent callback 함수 만들기
   $("#bc").css("display", "block"); 
   $("#bf").css("display", "none");
   var idx = data.idx;
   var title = data.title;
   var contents = data.contents;
   var writer = data.writer;
   $("#idx").val(idx);
   
}
function btnWrite() {
   $("#bc").css("display", "none"); 
   $("#bf").css("display", "block"); //display = none 이였던걸 보여주라라는 뜻
   $("#resetbtn").trigger("click"); //글쓰기후 글쓰기를 새로할때 전에 입력한 정보가 리셋되는 느낌
}
function delbtn(idx) {
   if(confirm("정말 삭제하시겠습니까?")==true){
   $.ajax({ 
      url : "delete.do",
      type : "get",
      data : {"idx": idx},
      success : list,
       error : function() {alert("error");}
   });
 }else{
   return false;
 }
}
function writeFn() {
   var formdata=$("#frm").serialize(); //boardForm에 form아이디를 불러옴 serialize란 폼안에 있는 모든 데이터를 읽어올 수 있다.
   //alert(data);
   $.ajax({
      url : "ajaxregister.do",
      type : "post",
      data :formdata ,
      success : list,
      error : function () {alert("error");}               
   });
}
</script>
</head>
<body>
   
   <input type="button" value="게시판리스트 가져오기(Ajax)" id="btn" class="btn btn-warning">
   <div id="msg">여기에 게시판 리스트를 출력하시오</div>
   <div style="display: none" id="bf">
   <c:import url="boardForm.jsp"/>    <%-- boardForm 임포트--%>>
    </div>
    <div style="display: none;" id="bc">
    <c:import url="boardContent.jsp"/>
    </div>
</body>
</html>
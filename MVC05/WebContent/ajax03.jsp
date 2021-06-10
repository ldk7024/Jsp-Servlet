<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(()=>{
		// CalcController <- calc.do
		$("#btn").click(()=>{			// ()=>{} 람다식 함수
			var su = $("#su").val();
			$.ajax({
				url : "calc.do",  // 서버로 요청-> CalcController
				type : "get",
				data : {"su": su},  // su=100  // 여러 데이터 넘기려면 "su": su, "su1": su, ... 
				//dataType : "json",
				success : callBack,
				error : function(){alert("error"); }
					
			});
		});		
	});
function callBack(data){
	//alert(data);
	$("#msg").html(data);
}

</script>
</head>
<body>
<input type="text" name="su" id="su">
<input type="button" value="클릭" id="btn">
<div id="msg">여기에 결과값을 출력</div>
</body>
</html>
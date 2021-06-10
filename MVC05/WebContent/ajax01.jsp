<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function calc(){
		var su = document.getElementById("su").value;
		var sum = 0;
		for(var i = 1;i<=su;i++){
			sum+=i;
		}
		
		//alert(sum);
		document.getElementById("msg").innerHTML="<font color='red'>"+sum+"<font>";
	}

</script>
</head>
<body>
<input type="text" name="su" id="su">
<input type="button" value="클릭" onclick="calc()">
<div id="msg">여기에 결과값을 출력</div>
</body>
</html>
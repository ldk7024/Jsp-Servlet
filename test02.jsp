<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String [] movName = {"이명진", "유미호건","고승우"};
	String [] movStroy ={"타이크명진", "호건유","류준열승우 람머스"};

%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center">
  <h1>갹갹갹</h1>
  <p>friends</p> 
</div>
  
<div class="container">
  <div class="row">
  <%for (int i =1 ; i<=3 ; i++){ %>
    <div class="col-sm-4">
    <h3><%= movName[i-1] %></h3>
    <p><img src = "images/img<%= i%>.jpg" width ="250" heght ="350"></p>
    <p><%= movStroy[i-1] %></p>
    </div>
    <% } %>
  </div>
</div>
</body>
</html>
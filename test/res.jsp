<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>たいぽんちゃんねる</title>
    <link rel="stylesheet" href="style.css" type="text/css" />
    
    <script> 

function double(btn){ 
good.disabled=true; 
bad.disabled=true; 

} 
</script>
    
</head>
<body>
    <nav>
      <div class="in">
      <ul class="menu">
        <a href="index"><img src="top.png"width=50%></a>
      <a href="index"> <img src="suretate.png"width=7% align="right" margin=1%></a>
      </ul>
      
       <% if(session.getAttribute("uname")==null){ %>
			<a href="login">ログイン</a><br/><a href="Register.html">新規アカウント作成</a>
		<% }else{ %>
			${sessionScope.uname}
			<form method="get" action="LoginServlet">
				<input type="submit" value="logout">
			</form>
			<% session.setAttribute("username",session.getAttribute("uname")); %>
		<% } %><br/>
		
    </div>
    </nav>
    
   
	<c:forEach var="res" items="${res}">

		<table>

			<tr><th>レスNO.${res.getNo()}</th><th>${res.resUser}</th><td>${res.resDate}</td><th>Good:${res.getLike()}</th>
			<th><form action='LikeServlet' method="get" onSubmit="return double()">
			<input id ="good" type="submit" name="like" value="Good" onClick="javascript:double(this)">
			<input id = "bad" type="submit" name="like" value="Bad" onClick="javascript:double(this)">
			<input type="hidden" name="rID" value="${res.getResID()}"><input type="hidden" name="id" value="${param.id}"></form></th></tr>
			<tr><td colspan="4">${res.getResContent()}</td></tr>
		</table>
		
		<hr>
	</c:forEach>
	
	   <b>スレッドID : <% request.getAttribute("id"); %>${param.id}</b>
		
	   
	   <form action='ResServlet?id=${param.id}'  method="post">
	   		<textarea cols="50" rows="5" name="content"></textarea>
	   		<input type="hidden" name="TID" value='${param.id}'><br/>
	   		<input type="submit" value="post"><span style='color:red'>${m}</span>
	   </form>
</body>
</html>
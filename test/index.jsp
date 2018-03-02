<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>


<html>
<head>
	<title>Thaipon</title>
	<link rel="stylesheet" href="style.css" type="text/css" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
    
      <div class="in">
      <ul class="menu">
        <img src="top.png"width=40%>
      <a href="#"> <img src="suretate.png"width=7% align="right" margin=1%></a>
        
      </ul>
    </div>
    
    
    
    <% if(session.getAttribute("uname")==null){ %>
		<h3><a href="login">ログイン</a><br/><a href="Register.html">新規アカウント作成</a></h3>
	<% }else{ %>
		${sessionScope.uname}
		<form method="get" action="LoginServlet">
		<input type="submit" value="logout">
		</form>
		<% session.setAttribute("username",session.getAttribute("uname")); %>
	<% } %>
	
	
	
<table>
		<tr><th>No</th><th>ID</th><th>スレッド名</th><th>ユーザー名</th><th>Date</th></tr>
		<% if(request.getAttribute("thread")==null){
				response.sendRedirect("ThreadServlet");} %>
		<c:forEach var="thread" items="${thread}">
			<tr><td>${thread.getNo()}&nbsp;&nbsp;</td><td>${thread.ID}&nbsp;&nbsp;</td><td><a href="ResServlet?id=${thread.ID}" method='get'>${thread.threadName}</a>&nbsp;&nbsp;</td><td>${thread.getThreadUser()}</td>&nbsp;<td>${thread.threadDate}</td>&nbsp;</tr>
		</c:forEach>
		
	</table><hr/>
	
	<center><form method="post" action="ThreadServlet">
	<h2>新しいスレッドを作成する</h2>
	<input type="text" name="Tname"size="40"/><br/><input type="submit" value="作成"><span style='color:red'>${m}</span>
	</form></center>
</body>

</html>
<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>


<html>
<head>
	<title>�����ۂ񂿂��˂�</title>
	<link rel="stylesheet" href="style.css" type="text/css" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
    <nav>
      <div class="in">
      <ul class="menu">
        <img src="top.png"width=50%>
      <a href="#"> <img src="suretate.png"width=7% align="right" margin=1%></a>
        
      </ul>
    </div>
    </nav>
    
    
    <% if(session.getAttribute("uname")==null){ %>
		<a href="login">login</a><br/><a href="Register.html">New Account!</a>
	<% }else{ %>
		${sessionScope.uname}
		<form method="get" action="LoginServlet">
		<input type="submit" value="logout">
		</form>
		<% session.setAttribute("username",session.getAttribute("uname")); %>
	<% } %>
	
	
	
<table>
		<tr><th>No</th><th>ID</th><th>�X���b�h��</th><th>���[�U�[��</th><th>Date</th></tr>
		<% if(request.getAttribute("thread")==null){
				response.sendRedirect("ThreadServlet");} %>
		<c:forEach var="thread" items="${thread}">
			<tr><td>${thread.getNo()}</td><td>${thread.ID}</td><td><a href="ResServlet?id=${thread.ID}" method='get'>${thread.threadName}</a></td><td>${thread.getThreadUser()}</td><td>${thread.threadDate}</td></tr>
		</c:forEach>
		
	</table><hr/></p>
	
	<form method="post" action="ThreadServlet">
	<input type="text" name="Tname"/><input type="submit" value="�X���b�h�𗧂Ă�"><span style='color:red'>${m}</span>
	</form>
</body>

</html>
<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Test</title>
	
</head>
<body>
	<!--<% try{ %>-->
	<c:forEach var="res" items="${res}">

		<table border = "1">

			<tr><th>${res.resUser}</th><td>${res.resDate}</td><td>${res.like}</td></tr>
			<tr><td colspan="4">${res.getResContent()}</td></tr>
		</table>
		<hr>
	</c:forEach>
	<!--<% }catch(Exception e){
				e.printStackTrace();
	   } %>-->
	   <b><% request.getAttribute("id"); %>${param.id}</b>
	   ${sessionScope.uname}
	   <form action='ResServlet?id=${param.id}'  method="post">
	   		<textarea cols="50" rows="5" name="content"></textarea>
	   		<input type="hidden" name="username" value="${sessionScope.uname}">
	   		<input type="hidden" name="TID" value='${param.id}'>
	   		<input type="submit" value="post">
	   </form>
</body>
</html>
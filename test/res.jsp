<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Test</title>
	
</head>
<body>
	<% try{ %>
	<c:forEach var="res" items="${res}">

		<table border = "1">
			<tr><th>${res.resUser}</th><td>${res.resDate}</td><td>0</td><td>0</td></tr>
			<tr><td colspan="4">${res.resContent}</td></tr>
		</table>
		<hr>
	</c:forEach>
	<% }catch(Exception e){
				e.printStackTrace();
	   } %>
</body>
</html>
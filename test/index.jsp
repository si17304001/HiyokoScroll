<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<html>
<head>
	<title>Test</title>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<table border="1">
		<tr><th>ID</th><th>Thread Name</th><th>User</th><th>Date</th></tr>
		<c:forEach var="thread" items="${thread}">
			<tr><td>${thread.ID}</td><td><a href="ResServlet?id=${thread.ID}">${thread.threadName}</a></td><td>${thread.userName}</td><td>${thread.threadDate}</td></tr>
		</c:forEach>
	</table>
</body>
</html>

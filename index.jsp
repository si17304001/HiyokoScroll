<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>


<html>
<head>
	<title>�����ۂ񂿂��˂�</title>
	<link rel="stylesheet" href="style.css" type="text/css" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

    <nav>
      <div class="in">
      <ul class="menu">
        <a href="">�z�[����</a>
        <a><img src="top.png"width=50%><a>
      <a href="#"> <img src="suretate.png"width=7% align="right" margin=1%></a>
        
      </ul>
    </div>
    </nav>
    
<body>
<p><table>
		<tr><th>ID</th><th>�X���b�h��</th><th>���[�U�[��</th><th>Date</th></tr>
		<c:forEach var="thread" items="${thread}">
			<tr><td>${thread.ID}</td><td><a href="ResServlet?id=${thread.ID}">${thread.threadName}</a></td><td>${thread.getThreadUser()}</td><td>${thread.threadDate}</td></tr>
			
		</c:forEach>
		
	</table><hr/></p>
</body>

</html>
<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<link rel="stylesheet" href="style.css" type="text/css" />
<html>
<head>
	<title>トップページ</title>
	
</head>

    <nav>
      <div class="in">
      <ul class="menu">
        <!--<a href="">ホームへ</a>-->
        <a><img src="top.png"width=50%><a>
      <a href="#"> <img src="suretate.png"width=7% align="right" margin=1%></a>
        
      </ul>
    </div>
    </nav>
    
<body>
<p><table>
		<tr><th>ID</th><th>スレッド名</th><th>ユーザー名</th><th>日付</th></tr>
		<c:forEach var="thread" items="${thread}">
						<tr><td>${thread.ID}&nbsp;&nbsp;</td><td><a href="ResServlet?id=${thread.ID}">${thread.threadName}</a>&nbsp;&nbsp;</td><td>${thread.getThreadUser()}</td>&nbsp;<td>${thread.threadDate}&nbsp;</td></tr>
			
		</c:forEach>
		
	</table><hr/></p>
	<input type="text">
</body>

</html>
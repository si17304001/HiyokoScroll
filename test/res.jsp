<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Thaipon</title>
    <link rel="stylesheet" href="StyleSheet/style.css" type="text/css" />
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script>
      $(function(){
        // #で始まるリンクをクリックしたら実行されます
        $('a[href^="#"]').click(function() {
          // スクロールの速度
          var speed = 600; // ミリ秒で記述
          var href= $(this).attr("href");
          var target = $(href == "#" || href == "" ? 'html' : href);
          var position = target.offset().top;
          $('body,html').animate({scrollTop:position}, speed, 'swing');
          return false;
        });
      });
    </script>
    
</head>
<body>
	<header>
		<div id="user">
			<% if(session.getAttribute("uname")==null){ %>
				<h3><a href="login">ログイン</a><br/><a href="register">新規アカウント作成</a></h3>
			<% }else{ %>
				<h3>ようこそ ${sessionScope.uname}さん！</h3>
				<form method="get" action="LoginServlet">
					<input type="submit" value="logout">
				</form>
			<% session.setAttribute("username",session.getAttribute("uname")); %>
			<% } %>
		</div>
		<div class="menu">
			<a href="index"><img src="image/top.jpg"width=40%></a>
			<a href="index"><img src="image/home.png" height="80px"></a>
			<a href="#postform"> <img src="image/newres.png"width=7% align="right" margin=1%></a>
		</div>
	</header>
	<!--ThreadID&Name-->
	<strong style="float: right; margin-right: 10px;">スレッドID : <% request.getAttribute("id"); %>${param.id}</strong>
	
	<center><h1>スレッド名：${threadname}</h1></center>
	
	<!--Res-->
	<div id="Main">
		<c:forEach var="top" items="${top}">
			<div class="top">
				<table>
					<tr><th>トップレス</th><th>${top.getResUser()}</th><th>${top.getResDate()}</th><th>Like:${top.getLike()}</th></tr>
				</table>
				<p>${top.getResContent()}</p>
				</div>
				<% if(session.getAttribute("uname")==null){ %>
				<% }else{ %>
				
				<div class="button">
					<form action='LikeServlet' method="get">
						<input type="submit" name="like" value="Good" id="good"><input type="submit" name="like" value="Bad" id="bad">
						<input type="hidden" name="rID" value="${top.getResID()}"><input type="hidden" name="id" value="${param.id}">
					</form>
				</div>
				<% } %>
		<hr>
		</c:forEach>
		<c:forEach var="res" items="${res}">
			<div class="res">
				<table>
					<tr><th>レスNO.${res.getNo()}</th><th>${res.resUser}</th><th>${res.resDate}</th><th>Like:${res.getLike()}</th></tr>
				</table>
				<p>${res.getResContent()}</p>
			</div>
			<% if(session.getAttribute("uname")==null){ %>
			<% }else{ %>
				<div class="button">
					<form action='LikeServlet' method="get">
						<input type="submit" name="like" value="Good" id="good"><input type="submit" name="like" value="Bad" id="bad">
						<input type="hidden" name="rID" value="${res.getResID()}"><input type="hidden" name="id" value="${param.id}">
					</form>
				</div>
			<% } %>
			<hr>
		</c:forEach>
	</div>
	
	<!--Post form-->
	   
		
	   <div id = "postform">
	   <form action='ResServlet?id=${param.id}'  method="post">
	   		<textarea cols="50" rows="5" name="content"></textarea>
	   		<input type="hidden" name="TID" value='${param.id}'><br/>
	   		<input type="submit" value="送信"><span style='color:red'>${m}</span>
	   </form>
	   </div>
</body>
</html>
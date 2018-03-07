<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
	
<html>
<head>
	<title>ログイン</title>
	<link rel="stylesheet" href="StyleSheet/style.css" type="text/css" />
</head>
<body>
	<header>
		<div id="user">
			<h3><a href="index.jsp">トップページへ</a><br/><a href="register">新規アカウント作成</a></h3>
		</div>
		<div class="menu">
			<a href="index"><img src="image/top.jpg"width=40%></a>
		</div>
	</header>
	<center><h1>ログイン</h1>
	<form method="post" action="LoginServlet">
		<h2>ユーザーID</h2><t><input type="text" name="username" pattern=".{5,20}" required><br/>
		<h2>パスワード<h2><t><input type="password" name="pass" pattern=".{5,20}" required></br>
		<input type="submit" value="ログイン"><span style='color:red'>${lmes}</span>
	</form>
</body>
</html>
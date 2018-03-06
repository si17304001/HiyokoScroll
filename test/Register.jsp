<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
	
<!DOCTYPE html>

<html>
<head>
	<title>新規アカウント作成</title>
	<link rel="stylesheet" href="StyleSheet/style.css" type="text/css" />
</head>
<body>
	<header>
		<div id="user">
			<h3><a href="index.jsp">トップページへ</a><br/><a href="login">ログイン</a></h3>
		</div>
		<div class="menu">
			<a href="index"><img src="image/top.jpg"width=40%></a>
		</div>
	</header>
	<center><h1>新規アカウント作成</h1><form method="post" action="ca">
		<h2>ユーザーID</h2><input type="text"  name="user" pattern=".{5,20}" required><br>
		<h2>パスワード</h2><input type="password" name="pass" pattern=".{5,20}" required><br>
		<input type="submit" value="登録" ><span style='color:red'>${ames}</span>
	</form></center>
</body>
</html>

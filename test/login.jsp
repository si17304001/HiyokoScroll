<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
	<link rel="stylesheet" href="style.css" type="text/css" />
<html>
	<head>
		<title>ログイン</title>
	</head>
	<body>
	<ul class="menu">
        <img src="top.png"width=40%>
      </ul>
      <center><h1>ログイン</h1>
		<form method="post" action="LoginServlet">
			<h2>ユーザーID</h2><t><input type="text" name="username"><br/>
			<h2>パスワード<h2><t><input type="password" name="pass"></br>
			<input type="submit" value="ログイン">
		</form>
	</body>
</html>
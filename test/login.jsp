<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
	<link rel="stylesheet" href="style.css" type="text/css" />
<html>
	<head>
		<title>ログイン</title>
	</head>
	<body>
	<ul class="menu">
        <a href="index"><img src="top.png"width=40%></a>
      </ul>

		<h3><a href="index.jsp">トップページへ</a><br/><a href="Register.html">新規アカウント作成</a></h3>

      <center><h1>ログイン</h1>
		<form method="post" action="LoginServlet">
			<h2>ユーザーID</h2><t><input type="text" name="username"><br/>
			<h2>パスワード<h2><t><input type="password" name="pass"></br>
			<input type="submit" value="ログイン">
			
		</form>
	</body>
</html>
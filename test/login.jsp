<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
	
<html>
<head>
	<title>���O�C��</title>
	<link rel="stylesheet" href="StyleSheet/style.css" type="text/css" />
</head>
<body>
	<header>
		<div id="user">
			<h3><a href="index.jsp">�g�b�v�y�[�W��</a><br/><a href="register">�V�K�A�J�E���g�쐬</a></h3>
		</div>
		<div class="menu">
			<a href="index"><img src="image/top.jpg"width=40%></a>
		</div>
	</header>
	<center><h1>���O�C��</h1>
	<form method="post" action="LoginServlet">
		<h2>���[�U�[ID</h2><t><input type="text" name="username" pattern=".{5,20}" required><br/>
		<h2>�p�X���[�h<h2><t><input type="password" name="pass" pattern=".{5,20}" required></br>
		<input type="submit" value="���O�C��"><span style='color:red'>${lmes}</span>
	</form>
</body>
</html>
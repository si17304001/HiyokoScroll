<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
	
<!DOCTYPE html>

<html>
<head>
	<title>�V�K�A�J�E���g�쐬</title>
	<link rel="stylesheet" href="StyleSheet/style.css" type="text/css" />
</head>
<body>
	<header>
		<div id="user">
			<h3><a href="index.jsp">�g�b�v�y�[�W��</a><br/><a href="login">���O�C��</a></h3>
		</div>
		<div class="menu">
			<a href="index"><img src="image/top.jpg"width=40%></a>
		</div>
	</header>
	<center><h1>�V�K�A�J�E���g�쐬</h1><form method="post" action="ca">
		<h2>���[�U�[ID</h2><input type="text"  name="user" pattern=".{5,20}" required><br>
		<h2>�p�X���[�h</h2><input type="password" name="pass" pattern=".{5,20}" required><br>
		<input type="submit" value="�o�^" ><span style='color:red'>${ames}</span>
	</form></center>
</body>
</html>

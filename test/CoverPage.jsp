<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<!DOCTYPE html>
<html>
<head>
	<title>top page</title>
	<link rel="stylesheet" type="text/css" href="StyleSheet/style.css">
</head>
<body>
	<header>
		<div class="menu">
			<a href="index"><img src="image/top.jpg"width=40%></a>
		</div>
	</header>
	<br>
<center><script> 

var cook; //cookie�f�[�^���i�[���� 
var cStart,cEnd; //�K��񐔕�����؎��ׂ̈ʒu���i�[ 
var cnt; //�K��񐔂��i�[ 

//cookie���g���邩�m�F 
if (navigator.cookieEnabled) 
{ 
cook=document.cookie + ";"; //�ϐ�cook��cookie�f�[�^������ 

//�ϐ�cStart�ɃJ�E���g�f�[�^�̍ŏ��̈ʒu������ 
cStart = cook.indexOf("counts=",0); 

//�f�[�^�̗L���ŕ��� 
if (cStart == -1) 
{ 
//�f�[�^�̖����ꍇ�͍ŏ��̖K��Ƃ������� 
document.write("1��ڂ̖K��ł��I".fontcolor("red")+"<br>"); 

//cookie�ɖK���=1���������� 
document.cookie="counts=1;"; 
} 
else 
{ 
//�J�E���g�f�[�^�̍Ō�̕����u;�v�̈ʒu���擾 
cEnd=cook.indexOf(";",cStart); 

//���l�̕���������؂��� 
cnt=cook.substring(cStart+7,cEnd); 

//���l�ɕϊ��ł��Ȃ���O���o�����̏��� 
try 
{ 
//�擾�����񐔂�+1���ĕ\������ 
cnt=parseInt(cnt)+1; 
document.write("�{��"+cnt+"��ڂ̖K��ł��I"); 

//cookie�ɖK��񐔂��������� 
document.cookie="counts="+cnt+";"; 
} 
catch(e) 
{ 
document.write("�K��񐔂̎擾�Ɏ��s���܂����B".fontcolor("red")+"<br>"); 
} 
} 
} 
else 
{ 
//cookie���g�p�ł��Ȃ����̏��� 
document.write("cookie���g�p�ł��܂���B".fontcolor("red")+"<br>"); 
} 
</script></center>

	<div id="start">
		<center><h1><a href="login">���O�C��</a></h1><br/>
		<h1><a href="Register.html">�V�K�A�J�E���g�쐬</a></h1><br>
		<h1><a href="index">�g�b�v�y�[�W��</a></h1><center>
	</div>
</body>
</html>
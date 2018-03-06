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

var cook; //cookieデータを格納する 
var cStart,cEnd; //訪問回数部分を切取る為の位置を格納 
var cnt; //訪問回数を格納 

//cookieが使えるか確認 
if (navigator.cookieEnabled) 
{ 
cook=document.cookie + ";"; //変数cookにcookieデータを入れる 

//変数cStartにカウントデータの最初の位置を入れる 
cStart = cook.indexOf("counts=",0); 

//データの有無で分岐 
if (cStart == -1) 
{ 
//データの無い場合は最初の訪問ということ 
document.write("1回目の訪問です！".fontcolor("red")+"<br>"); 

//cookieに訪問回数=1を書き込む 
document.cookie="counts=1;"; 
} 
else 
{ 
//カウントデータの最後の部分「;」の位置を取得 
cEnd=cook.indexOf(";",cStart); 

//数値の部分だけを切り取る 
cnt=cook.substring(cStart+7,cEnd); 

//数値に変換できない例外が出た時の処理 
try 
{ 
//取得した回数に+1して表示する 
cnt=parseInt(cnt)+1; 
document.write("本日"+cnt+"回目の訪問です！"); 

//cookieに訪問回数を書き込む 
document.cookie="counts="+cnt+";"; 
} 
catch(e) 
{ 
document.write("訪問回数の取得に失敗しました。".fontcolor("red")+"<br>"); 
} 
} 
} 
else 
{ 
//cookieが使用できない時の処理 
document.write("cookieが使用できません。".fontcolor("red")+"<br>"); 
} 
</script></center>

	<div id="start">
		<center><h1><a href="login">ログイン</a></h1><br/>
		<h1><a href="Register.html">新規アカウント作成</a></h1><br>
		<h1><a href="index">トップページへ</a></h1><center>
	</div>
</body>
</html>
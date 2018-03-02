<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>


<html>
<head>
	<title>Thaipon</title>
	<link rel="stylesheet" href="style.css" type="text/css" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	
	<script>
		jQuery(function ($){
	//セレクトが変更されたら実行する
			$('#tag-select').change(function (){
				var select_val = $('#tag-select option:selected').val();
			
			//tableのTrの回数分処理を実行
			$.each($("#thread tbody tr"), function(index,element){
				//選択した行が空欄(クリア)だったら全行を選択
				if(select_val == ""){
					$(element).css("display","table-row");
					return true;
					//次のTr
				}
				//テキストとして取り出してセレクトボックスと比較
				var row_text = $(element).text();
				
				if(row_text.indexOf(select_val) != -1){
					//見つかった場合は表示
					$(element).css("dispaly", "table-row");
				}else{
					$(element).css("display", "none");
				}
			});
		});
	});
	</script>
</head>
<body>
    <nav>
      <div class="in">
      <ul class="menu">
        <a href="index"><img src="top.png"width=40%></a>
      <a href="#"> <img src="suretate.png"width=7% align="right" margin=1%></a>
        
      </ul>
    </div>
    </nav>
    
    <% if(session.getAttribute("uname")==null){ %>
		<h3><a href="login">ログイン</a><br/><a href="Register.html">新規アカウント作成</a></h3>
	<% }else{ %>
		${sessionScope.uname}
		<form method="get" action="LoginServlet">
		<input type="submit" value="logout">
		</form>
		<% session.setAttribute("username",session.getAttribute("uname")); %>
	<% } %>
	
	<center><div id="pref-search">
		<select id ="tag-select" class ="form-control">
			<option value ="">全て表示</option>
			<option value ="ゲーム">ゲーム</option>
			<option value ="雑談">雑談</option>
			<option value ="アニメ">アニメ</option>
			<option value ="その他">その他</option>
		</select>
	</div></center>
	
<table id="thread">
	
	<tr><th>No</th><th>ID</th><th>スレッド名</th><th>ユーザー名</th><th>日付</th><th>タグ</th></tr>
		<% if(request.getAttribute("thread")==null){
				response.sendRedirect("ThreadServlet");} %>
	<tbody><c:forEach var="thread" items="${thread}">
			<tr><td>${thread.getNo()}&nbsp;&nbsp;</td>
			<td>${thread.ID}&nbsp;&nbsp;</td>
			<td><a href="ResServlet?id=${thread.ID}" method='get'>${thread.threadName}&nbsp;&nbsp;</a></td>
			<td>${thread.getThreadUser()}&nbsp;&nbsp;</td>
			<td>${thread.threadDate}&nbsp;&nbsp;</td>
			<td>${thread.getTag()}&nbsp;&nbsp;</td></tr>
		</c:forEach>
	</tbody>
	</table><hr/></p>
	
	<center><form method="post" action="ThreadServlet">
		<h2>新しいスレッドを作成する</h2>
		<select name="tag">
			<option value ="雑談">雑談</option>
			<option value ="ゲーム">ゲーム</option>
			<option value ="アニメ">アニメ</option>
			<option value ="その他" selected="selected">その他</option>
		</select>
		<!--<input type="radio" name="tag" value="ゲーム"> ゲーム
		<input type="radio" name="tag" value="アニメ">アニメ
		<input type="radio" name="tag" value="雑談">雑談
		<input type="radio" name="tag" value="その他" checked="checked">その他-->
		<input type="text" name="Tname"/>&nbsp;<input type="submit" value="作成"><span style='color:red'>${m}</span>
	</form></center>
</body>

</html>
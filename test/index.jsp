<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>


<html>
<head>
	<title>Thaipon</title>
	<link rel="stylesheet" href="StyleSheet/style.css" type="text/css" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script>
      $(function(){
        // #�Ŏn�܂郊���N���N���b�N��������s����܂�
        $('a[href^="#"]').click(function() {
          // �X�N���[���̑��x
          var speed = 600; // �~���b�ŋL�q
          var href= $(this).attr("href");
          var target = $(href == "#" || href == "" ? 'html' : href);
          var position = target.offset().top;
          $('body,html').animate({scrollTop:position}, speed, 'swing');
          return false;
        });
      });
      
		jQuery(function ($){
	//�Z���N�g���ύX���ꂽ����s����
			$('#tag-select').change(function (){
				select_val = $('#tag-select option:selected').val();
			
			//table��Tr�̉񐔕����������s
			$.each($("#thread tbody tr"), function(index,element){
				//�I�������s����(�N���A)��������S�s��I��
				if(select_val == ""){
					$(element).css("display","table-row");
					return true;
					//����Tr
				}
				//�e�L�X�g�Ƃ��Ď��o���ăZ���N�g�{�b�N�X�Ɣ�r
				var row_text = $(element).text();
				
				if(row_text.indexOf(select_val) != -1){
					//���������ꍇ�͕\��
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
<header>
		<div id="user">
			<% if(session.getAttribute("uname")==null){ %>
				<h3><a href="login">���O�C��</a><br/><a href="register">�V�K�A�J�E���g�쐬</a></h3>
			<% }else{ %>
				<h3>�悤���� ${sessionScope.uname}����I</h3>
				<form method="get" action="LoginServlet">
					<input type="submit" value="logout">
				</form>
			<% session.setAttribute("username",session.getAttribute("uname")); %>
			<% } %>
		</div>
		<div class="menu">
			<a href="index"><img src="image/top.jpg"width=40%></a>
			<a href="index"><img src="image/home.png" height="80px"></a>
			<a href="#postform"> <img src="image/suretate.jpg"width=7% align="right" margin=1%></a>
		</div>
	</header>
	<br>
	<div id="Main">
		<div id="pref-search">
			<select id ="tag-select" class ="form-control">
				<option value ="">�S�ĕ\��</option>
				<option value ="�Q�[��">�Q�[��</option>
				<option value ="�G�k">�G�k</option>
				<option value ="�A�j��">�A�j��</option>
				<option value ="���̑�">���̑�</option>
			</select>
		<input type="button" value="�i�荞�݃N���A" onclick="koshin()">
	
		<script> function koshin(){ location.reload(); } </script>
		</div>
		
		<table id="thread">
	
			<tr><th>No</th><th>�X���b�h��</th><th>���[�U�[��</th><th>���t</th><th>�^�O</th></tr>
			<% if(request.getAttribute("thread")==null){
			response.sendRedirect("ThreadServlet");} %>
		<tbody><c:forEach var="thread" items="${thread}">
				<tr><td>${thread.getNo()}&nbsp;&nbsp;</td>
				<td><a href="ResServlet?id=${thread.ID}" method='get'>${thread.threadName}&nbsp;&nbsp;</a></td>
				<td>${thread.getThreadUser()}&nbsp;&nbsp;</td>
				<td>${thread.threadDate}&nbsp;&nbsp;</td>
				<td>${thread.getTag()}&nbsp;&nbsp;</td></tr>
			</c:forEach>
		</tbody>
		</table><hr/>
	</div>
	<div id="postform">
		<center><form method="post" action="ThreadServlet">
			<h2>�V�����X���b�h���쐬����</h2>
			<select name="tag">
				<option value ="�G�k">�G�k</option>
				<option value ="�Q�[��">�Q�[��</option>
				<option value ="�A�j��">�A�j��</option>
				<option value ="���̑�" selected="selected">���̑�</option>
			</select>
			<input type="text" name="Tname"/>&nbsp;<input type="submit" value="�쐬"><span style='color:red'>${m}</span>
		</form><center>
	</div>
</body>

</html>
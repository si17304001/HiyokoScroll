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
	//�Z���N�g���ύX���ꂽ����s����
			$('#tag-select').change(function (){
				var select_val = $('#tag-select option:selected').val();
			
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
    <nav>
      <div class="in">
      <ul class="menu">
        <a href="index"><img src="top.png"width=40%></a>
      <a href="#"> <img src="suretate.png"width=7% align="right" margin=1%></a>
        
      </ul>
    </div>
    </nav>
    
    <% if(session.getAttribute("uname")==null){ %>
		<h3><a href="login">���O�C��</a><br/><a href="Register.html">�V�K�A�J�E���g�쐬</a></h3>
	<% }else{ %>
		${sessionScope.uname}
		<form method="get" action="LoginServlet">
		<input type="submit" value="logout">
		</form>
		<% session.setAttribute("username",session.getAttribute("uname")); %>
	<% } %>
	
	<center><div id="pref-search">
		<select id ="tag-select" class ="form-control">
			<option value ="">�S�ĕ\��</option>
			<option value ="�Q�[��">�Q�[��</option>
			<option value ="�G�k">�G�k</option>
			<option value ="�A�j��">�A�j��</option>
			<option value ="���̑�">���̑�</option>
		</select>
	</div></center>
	
<table id="thread">
	
	<tr><th>No</th><th>ID</th><th>�X���b�h��</th><th>���[�U�[��</th><th>���t</th><th>�^�O</th></tr>
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
		<h2>�V�����X���b�h���쐬����</h2>
		<select name="tag">
			<option value ="�G�k">�G�k</option>
			<option value ="�Q�[��">�Q�[��</option>
			<option value ="�A�j��">�A�j��</option>
			<option value ="���̑�" selected="selected">���̑�</option>
		</select>
		<!--<input type="radio" name="tag" value="�Q�[��"> �Q�[��
		<input type="radio" name="tag" value="�A�j��">�A�j��
		<input type="radio" name="tag" value="�G�k">�G�k
		<input type="radio" name="tag" value="���̑�" checked="checked">���̑�-->
		<input type="text" name="Tname"/>&nbsp;<input type="submit" value="�쐬"><span style='color:red'>${m}</span>
	</form></center>
</body>

</html>
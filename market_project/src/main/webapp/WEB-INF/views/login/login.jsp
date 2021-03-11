<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header/link.jsp" %>

<link href="resources/myCss/login.css" rel="stylesheet">

</head>
<body>
<%@ include file="../header/header.jsp" %>


<div class="login-div fadeInDown">
	
		<form action="/" method="post" name="login_form" class="login_form" autocomplete='off' >
					<div class="login_form_title">OBOOK</div>
					<input type="text" placeholder="ID" name="input_id" id="input_id_id"  autocomplete='off' class="login_input">
					<input type="password" placeholder="PASSWORD" name="input_pwd"  id="input_id_pwd" autocomplete=off class="login_input">
					<div>${nologin}</div>
					<input type="button"  onclick="blankCheck()"value="login" class="login_submit_btn">
					<input type="button" class="login_signIn_btn" onclick="location.href='join'" value="회원가입">
		</form>


</div>
<script>

var loginForm= document.login_form;

/*공백 허가X 처리  */
function blankCheck(){

	var id=$('#input_id_id').val();
	var pwd=$('#input_id_pwd').val();

	if(id==''||pwd==''){
		console.log(id);
		console.log(pwd);
		alert("공백을 입력하지마세요.");
		return false;
	}

		return checkLogin();
				
	
} 


function checkLogin() {
	
	console.log("come");
	var form = {
		id : $('#input_id_id').val(),
		pw : $('#input_id_pwd').val()
	}

	$.ajax({
		url : "checkLogin",
		type : "POST",
		data : form,
		success : function(data) {
			
			if(data=='로그인 성공'){
				loginForm.submit();
			}
			else{
	
				alert(data);

			}
		},
		error : function() {
			alert("simpleWithObject err");
		}
	});
};





</script>

</body>
</html>
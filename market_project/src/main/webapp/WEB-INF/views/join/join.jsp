<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header/link.jsp" %>

<link href="resources/myCss/join.css" rel="stylesheet">

</head>
<body>
<%@ include file="../header/header.jsp" %>

<div class="wrapper fadeInDown join-div">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->

    <!-- Login Form -->
	
		<form action="joinUser" method="post" onsubmit="return chk_result();" id="myForm"  class="login_form" autocomplete='off' >
	
				<div class="join_form_title">sign up</div>
			<div class="input_frame">	
				<input type="text" placeholder="NAME" name="input_name"
					autocomplete='off' id="input_name" class="join_input">
				<input type="text" placeholder="ID" name="input_id"
					id="input_id" autocomplete='off' class="join_input join_input_id">

				<!-- 아이디 중복체크 필요 -->
				<input type="button" value="중복확인" class="chk_id" />
							
				<input type="password" placeholder="PASSWORD" name="input_pwd"
					autocomplete='off' class="input_pwd join_input" id="input_pwd">
					
				<input type="password" placeholder="PASSWORD CHECK" autocomplete='off'
					class="input_pwd join_input" id="input_pwd_re" >

				<!-- 비밀번호 동일시 여부 체크  -->
					
			
				<input type="text" placeholder="EMAIL" name="input_email"
					autocomplete='off' id="input_email" class="join_input">
				<input type="tel" placeholder="PHONE" name="input_phone"
					autocomplete='off' id="input_phone" class="join_input">
					
				<input type="submit" value="가입" class="join_submit_btn"/>
				<input type="button" onclick='myReset()' value="다시작성" class="join_submit_btn">
				<input type="button" value="뒤로가기" onclick="history.back()" class="join_submit_btn">
				</div>
	
		</form>

    <!-- Remind Passowrd -->
    <!-- 구현필요 -->
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div>

  </div>
</div>


<script>


var chk_id_flag=false;


$('.chk_id').on('click', function() {
	
	console.log($('#input_id').val());
	if($('#input_id').val()==''){
		alert('아이디를 입력해주세요');
		return false;
	}
	
	var form = {
		id : $('#input_id').val()
	}

	$.ajax({
		url : "chk_id",
		type : "POST",
		data : form,
		success : function(data) {
			
			if(data=='아이디 중복'){
				alert('아이디가 중복됩니다.');
				chk_id_flag=false;
			
			}
			else{
				alert('사용가능한 아이디');
				chk_id_flag=true;
				$('#input_id').attr("readonly",true);
				$('#input_id').css('backgroundColor', '#d9d9d9');

			}
		},
		error : function() {
			alert("simpleWithObject err");
		}
	});
});

function chk_result(){
	
	var pw_1=$('#input_pwd').val();
	var pw_2=$('#input_pwd_re').val();
	
	if(chk_id_flag==false){
		
		alert('아이디 중복 체크를 해주세요');
		return false;
		
	}
	
	if(pw_1==pw_2){
		return true;
	}
	else{
		alert('비밀번호가 일치하지 않습니다');
		return false;
	}
	
}

function myReset(){
	
	$('#myform')[0].reset();
	$('#input_id').attr("readonly",false);
	$('#input_id').css('backgroundColor', '#ffffff');
	
	
}


	


</script>

</body>
</html>
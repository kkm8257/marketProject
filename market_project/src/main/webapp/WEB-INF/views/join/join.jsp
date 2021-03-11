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
	
		<form action="loginUser" method="post" onsubmit="return blankCheck();"  class="login_form" autocomplete='off' >
	
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
				<input type="button" value="뒤로가기" onclick="history.back()" class="join_submit_btn">
				</div>
	
		</form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div>

  </div>
</div>


<script>
	
	


</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이메일 중복확인</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/emailCheck.css">

</head>
<body>

	<%
		Object result = request.getAttribute("emailCheck");
	%>

	<script>
	
		function check(){
			var e_RegExp= /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			var email = document.getElementById("email");
			
			if(email.value ==''){
	            alert("이메일을 입력해주세요.");
	            return false;
	        }
	        if(!e_RegExp.test(email.value)){
	            alert("올바른 이메일 형식이 아닙니다.");        
	            return false;
	        }
		}
		
	</script>



	<!-- result 값이 null이거나 혹은 있거나, null이면 Servlet을 거치지 않고 바로 해당 페이지가 열렸을때 -->
	<%
		if (result == null) {
	%>
	<div class="bg-color">
		<div class="box-white">
			<form action="/member/emailCheck.do" method="get" onsubmit="return check();">
				<input type="email" class="input-style" id="email" name="email" placeholder="중복 확인할 이메일을 입력하세요" />
				<input type="submit" class="btn-s" id="email" value="중복확인" />
			</form>
		</div>
	</div>

	<!-- null이 아닐때 -->
	<%
		} else {
	%>

	<%
		String email = (String) request.getAttribute("email");
	%>
	<div class="bg-color">
		<div class="box-white">
			<form action="/member/emailCheck.do" method="get">
				<input type="email" class="input-style" id="email1" name="email"
					value="<%=email%>" placeholder="중복 확인할 이메일을 입력하세요" /> <input
					type="submit" class="btn-s" value="중복확인" /> <br>
				<br>
			</form>

			<%
				if ((boolean) result) {
			%>
			<span class="already">이미 사용중인 이메일입니다. 다시 확인해주세요.</span>

			<%
				} else {
			%>
			<span class="canuse">사용 가능한 이메일입니다.</span>
			<button class="btn-s" onclick="useEmail();">사용하기</button>
		</div>
	</div>
	<script>
		function useEmail() {
			window.opener.document.getElementById('email').value = document
					.getElementById("email1").value;
			window.close();
		}
	</script>
	<%
		}
	%>

	<%
		}
	%>

</body>
</html>
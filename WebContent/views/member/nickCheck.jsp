<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>닉네임 중복확인</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/nickCheck.css">

</head>
<body>
	<%
		Object result = request.getAttribute("nickCheck");
	%>

	<script>
	
		function check(){
			var n_RegExp= /^[가-힣ㄱ-ㅎa-zA-Z0-9._-]{2,16}\$/;
			var nick = document.getElementById("nick");
			
			if(nick.value ==''){
	            alert("닉네임을 입력해주세요.");
	            return false;
	        }
	        if(!n_RegExp.test(nick.value)){
	            alert("닉네임은 2~16자의 숫자, 한국어, 영어, '_'로만 만들어주세요.");        
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
			<form action="/member/nickCheck.do" method="get" onsubmit="return check();">
				<input type="text" class="input-style" id="nick" name="nick" placeholder="중복 확인할 닉네임을 입력하세요" />
				<input type="submit" class="btn-s" value="중복확인" />
			</form>
		</div>
	</div>
	
	
	
	
	<%
		} else {
	%>

	<%
		String nick = (String) request.getAttribute("nick");
	%>
	<div class="bg-color">
		<div class="box-white">
			<form action="/member/nickCheck.do" method="get">
				<input type="text" class="input-style" id="userNick3" name="nick" value="<%=nick%>" placeholder="중복 확인할 ID를 입력하세요" />
				<input type="submit" class="btn-s" value="중복확인" /><br><br>
			</form>

			<!-- 중복하는 닉네임이 왔을때 -->
			<%
				if ((boolean) result) {
			%>
			<span class="already">이미 사용중인 닉네임입니다. 다시 확인해주세요.</span>

			<!-- 중복하지 않는 닉네임일때 -->
			<%
				} else {
			%>
			<span class="canuse">사용 가능한 닉네임입니다.</span>
			<button class="btn-s" onclick="useNick();">사용하기</button>
		</div>
	</div>
	
	<script>
		function useNick() {
			window.opener.document.getElementById('nick').value = document.getElementById("userNick3").value;
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
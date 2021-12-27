<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 크루 삭제</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/crewDelete.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>
<body>

	<%	
		String crewName = (String)request.getAttribute("crewName");
		int crewNo = (int)request.getAttribute("crewNo");
	%>

	<div id="wrap">
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
		
		<% if(m!=null) {%>
		<div id="content">
			<div class=box-title>
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big">크루 삭제</p>
			</div>
			
			<div class="box-noti">
				<p class="txt-head">삭제 유의사항</p>
				<p>
					- 운영하고 계신 크루[<%=crewName %>]는 삭제할 경우 재사용 및 복구가 불가능합니다.<br>
					- 삭제 후 크루정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.
				</p>
				<div class="box-checkbox">
					<input type="checkbox" id="agree">
					<label for="agree">안내사항을 모두 확인하였으며, 이에 동의합니다.</label>
				</div>
			</div>
			
			<div class="box-btn">
				<button class="btn-m" id="">
					<a href="/crew/crewDelete.do?crewNo=<%=crewNo%>">완료</a>
				</button>
			</div>
		</div>
		
		<script>
		
		$(".btn-m").click(function(){
			
			var check = document.getElementById("agree").checked;
			
			//체크박스 눌러야만 넘어가도록
			if(!check) {
				alert("필수 약관에 동의해 주세요")
				return false;
			}
			
			//한번더 확인
			if(window.confirm("삭제를 진행하시게 되면 데이터는 복구 불가능합니다. \n삭제하시겠습니까?")) {
				return true;
			} else {
				return false;
			};
		});
		
		</script>
		
		
		<% } else { %>
			<script>
				location.replace("/views/member/memberLogin.jsp");
			</script>
		<%}  %>
		
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>	
	</div>
	
</body>
</html>
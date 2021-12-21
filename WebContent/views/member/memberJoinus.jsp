<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 회원가입</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/css/memberJoinus.css">
</head>

<body>
	<script>
	<!--ID 중복 체크 확인-->
		function idCheck()
		{
			//alert('jup-day'); 확인
			window.open("/views/member/idCheck.jsp","_blank","width=500px, height=150px");
		}
	</script>
	
    <script>
  	<!--ID란 바로 중복체크창으로 연결-->
	    function goIdCheck(){	
			window.open("/views/member/idCheck.jsp","_blank","width=500px, height=150px");
		
		}
    </script>
       

	<script>
	<!--nick 중복체크 확인 -->
		function nickCheck()
		{
			//AJAX배우면 수정?
			window.open("/views/member/nickCheck.jsp","_blank","width=500px, height=150px");
		}
   </script>

	<script>
	<!--nick창 누르면 바로 중복체크창으로 이동 -->
		function goNickCheck(){
			window.open("/views/member/nickCheck.jsp","_blank","width=500px, height=150px");
		}
	</script>
       
	<!-- 비밀번호 유효성 검사 확인-->
	<script>
	    //비밀번호 일치 및 조건
        function pwCheck(){
            var userPwd = document.getElementById('userPwd').value;
            var SC = ["!","@","#","$","%"];
            var check_SC = 0;
 			//비밀번호 길이
            if(userPwd.length<8 || userPwd.length>16){
                window.alert('비밀번호는 8글자 이상, 16글자 이하만 이용 가능합니다.');
                document.getElementById('userPwd').value='';
            }
            for(var i=0;i<SC.length;i++){
                if(userPwd.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }//비밀번호 특수문자 혼합 
            if(check_SC == 0){
                window.alert('비밀번호에 !,@,#,$,% 의 특수문자가 들어가 있지 않습니다.')
                document.getElementById('userPwd').value='';
            }//사용자에게 알려주기
            if(document.getElementById('userPwd').value !='' && document.getElementById('userPwdRe').value!=''){
                if(document.getElementById('userPwd').value==document.getElementById('userPwdRe').value){
                    document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                    document.getElementById('check').style.color='blue';     }
                else{
                	document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                    document.getElementById('check').style.color='red';
     	
                }
            }
        }
    </script>

	<script>
		<!-- 전체 약관 동의를 누르면 전체 선택 및 전체해제-->
		function selectAll(selectAll)  {
			const checkboxes = document.getElementsByName('jupday');
			  
			checkboxes.forEach((checkbox) =>{
			checkbox.checked = selectAll.checked
			})
		}

	<!--체크박스를 하나하나 클릭하여 전체를 선택하면 selectall 체크박스가 선택 ->
	<!--selectall 체크박스를 선택하여 전체선택을 한 경우, 체크박스가 하나라도 선택해제 되면, selectall 체크박스 역시 선택해제-->
	function checkSelectAll()  {
		// 전체 체크박스
		const checkboxes = document.querySelectorAll('input[name="jupday"]');
		// 선택된 체크박스
		const checked = document.querySelectorAll('input[name="jupday"]:checked');
		// select all 체크박스
		const selectAll = document.querySelector('input[name="selectall"]');
		
		if(checkboxes.length === checked.length)  {
		  selectAll.checked = true;
		}else {
		  selectAll.checked = false;
		}
	}		
	</script>
		 
	<div class="bg-color">
		<div class="box-white">
			<div class="logo-user"><a href="/"><img src="/assets/images/jupday_logo.png" alt="줍데이로고"></a></div>
			<form action="/member/memberJoin.do" method="post">
				<label for="userId" class="tit-label">아이디*</label><br>
				<input type="text" id="userId" class="input-join" name="userId" onclick="goidCheck();"  placeholder="아이디 입력 (8~12자)" maxlength="12">
				<input type="button" class="btn-verify" onclick="idCheck();" value="중복확인"><br>
				
				<label for="userPwd" class="tit-label">비밀번호*</label><br>
				<input type="password" id="userPwd" class="input-join2" name="userPwd" onchange="pw_check()" placeholder="비밀번호 입력 (영문, 숫자, 특수문자 조합  8~16자)" maxlength="16"> <br>
				<input type="password" class="input-join2" id="userPwdRe" name="userPwdRe" onchange="pw_check()"  placeholder="비밀번호 확인"><br>
				<span id="check"></span>
				
				
				<label for="nick" class="tit-label">닉네임*</label><br>
				<input type="text" id="nick" class="input-join" name="nick" onclick="go_nickCheck();" placeholder="닉네임 입력" >
				<input type="button" class="btn-verify" onclick="nickCheck();" value="중복확인"><br>
				
				<label for="email" class="tit-label">이메일*</label><br>
				<input type="email" id="email" class="input-join" name="email" placeholder="이메일">
				<input type="button" class="btn-verify" value="인증하기"><br>
				    	
	        	<h3 class="tit-join">이용 약관</h3>
	        	<div class="box-checkbox">
	        	    <input type="checkbox" name='jupday' value='terms1' onclick='checkSelectAll()'/><a href="">(필수) 개인정보 수집 이용동의</a><br>
		        	<input type="checkbox" name='jupday' value='terms2' onclick='checkSelectAll()'/><a href="">(필수) JUP:DAY 이용약관</a><br>
		        	<input type="checkbox" name='jupday' value='terms3' onclick='checkSelectAll()'/><a href="">(선택) 마케팅 활용 및 광고성 정보 수신 동의</a><br>
	        	 	<input type="checkbox" name='selectall' value='selectall' onclick='selectAll(this)' id="checkAll"><label for=checkAll>약관 전체 동의</label><br>
	        	 </div>
				<input type="submit" class="btn-submit" value="가입하기">
			</form>
		</div>
	</div>
	
	<!-- footer -->
	<%@ include file="/views/commons/footer/footer.jsp"%>
</body>
</html>
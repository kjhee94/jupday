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
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/css/memberJoinus.css">
</head>

<body>

	<!-- 비밀번호 유효성 검사 확인-->
	<script>
	    //비밀번호 일치 및 조건
        function pwCheck(){
            var userPwd = document.getElementById('userPwd').value;
            var SC = ["!","@","#","$","%","^","&","*","(",")"];//!@#$%^&*()
            var check_SC = 0;
 			//비밀번호 길이
            if(userPwd.length < 8 || userPwd.length > 16){
                window.alert('비밀번호는 8글자 이상, 16글자 이하만 이용 가능합니다.');
                document.getElementById('userPwd').value='';
            }
            for(var i=0;i<SC.length;i++){
                if(userPwd.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }//비밀번호 특수문자 혼합 
            if(check_SC == 0){
                window.alert('비밀번호에 !,@,#,$,%,^,&,*,(,) 의 특수문자가 들어가 있지 않습니다.')
                document.getElementById('userPwd').value='';
            }//사용자에게 알려주기
            if(document.getElementById('userPwd').value !='' && document.getElementById('userPwdRe').value!=''){
                if(document.getElementById('userPwd').value==document.getElementById('userPwdRe').value){
                    document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                    document.getElementById('check').style.color='green';     }
                else{
                	document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                    document.getElementById('check').style.color='red';
                    return false;
     	
                }
            }
        }
   	</script>

	<script>
		<!-- 전체 약관 동의를 누르면 전체 선택 및 전체해제-->
		function selectAll(selectAll)  {
			  const checkboxes 
			     = document.getElementsByName('jupday');
			  
			  checkboxes.forEach((checkbox) =>{
			    checkbox.checked = selectAll.checked
			  })
			}
	
		<!--체크박스를 하나하나 클릭하여 전체를 선택하면 selectall 체크박스가 선택 ->
		<!--selectall 체크박스를 선택하여 전체선택을 한 경우, 체크박스가 하나라도 선택해제 되면, selectall 체크박스 역시 선택해제-->
		function checkSelectAll()  {
			  // 전체 체크박스
			  const checkboxes 
			    = document.querySelectorAll('input[name="jupday"]');
			  // 선택된 체크박스
			  const checked 
			    = document.querySelectorAll('input[name="jupday"]:checked');
			  // select all 체크박스
			  const selectAll 
			    = document.querySelector('input[name="selectall"]');
			  
			  if(checkboxes.length === checked.length)  {

			    selectAll.checked = true;
			  }else {
			    selectAll.checked = false;
			  }
	
		}		
	 </script>
			 
	 <!-- 최종 제출전 다향성 검사 -->
	 <script>
		 function Validation(){
			 
	        var RegExp = /^[a-zA-Z0-9]{8,12}$/;  //id 영어와 숫자 글자수 검사
	        var pRegExp = /^[a-zA-Z0-9!@#$%^&*()]{8,16}$/;//pwassword 글자수 유효성 검사 정규식 
	        var eRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//이메일 유효성검사
			var nRegExp= /^[가-힣ㄱ-ㅎa-zA-Z0-9._-]{2,16}\$/;//nick 유효성 검사
			
	        var objId = document.getElementById("userId"); //아이디
	        var objPwd = document.getElementById("userPwd"); //비밀번호
	        var objPwdCheck = document.getElementById("userPwdRe"); //비밀번호확인
	        var objNick = document.getElementById("nick"); //이름
	        var objEmail = document.getElementById("email");//메일
	        var chk1=document.getElementById("checkAgreement").checked;//필수 약관 체크박스 체크여부 확인 [하나]
	        var chk2=document.getElementById("agreementCheck").checked;//필수 약관 체크박스 체크여부 확인 [둘]
	
	        
	        // ================ ID 유효성검사 ================ //
	        if(objId.value==''){
	            alert("ID를 입력해주세요.");
	            return false;
	        }
	        if(!RegExp.test(objId.value)){ //아이디 유효성검사
	            alert("ID는 8~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");        
	            return false;
	        }
	        
	        // ================ PASSWORD 유효성검사 ===============//
	        if(objPwd.value==''){ // 비밀번호 입력여부 검사
	            alert("Password를 입력해주세요.");
	            return false;
	        }
	
	        if(!pRegExp.test(objPwd.value)){ //패스워드 유효성검사
	
	            alert("Password는 8~16자의 영문 대소문자와 숫자 특수문자로만 입력하여 주세요.");
	            return false;
	        }
	        /*
	        if(objPwd.value==objId.value){ //패스워드와 ID가 동일한지 검사
	            alert("Password는 ID와 동일하면 안됩니다.");
	            return false;
	        }*/
	        
	        if(objPwdCheck.value!=objPwd.value){ //비밀번호와 비밀번호확인이 동일한지 검사
	            alert("비밀번호가 일치하지 않습니다. 다시 확인하여 입력해주세요.");
	            return false;
	        }
	        
	        //===============Nick 유효성 검사=========================//
	        if(objNick.value ==''){
	            alert("닉네임을 입력해주세요.");
	            return false;
	        }
	
	        if(!nRegExp.test(objNick.value)){ //닉네임
	            alert("닉네임을 2~16자의 숫자,한글,영어,'_'로 입력해주세요.");        
	            return false;
	        }
	        
	        // ================ email 유효성검사 ================ //
	        if(eRegExp.value == ''){ // 이메일 입력여부 검사
	
	            alert("이메일을 입력해주세요.");
	            return false;
	        }
	        if(!eRegExp.test(objEmail.value)){ //이메일 유효성 검사
	
	            alert("올바른 이메일 형식이 아닙니다.");
	            return false;
	        }
	
	        //==================필수약관 체크 여부 ==================== //
	        if(!chk1){
	            alert('필수 약관에 동의해 주세요');
	            return false;
	        } 
	        if(!chk2) {
	            alert('필수 약관에 동의해 주세요');
	            return false;
	        }
	 	}
	</script>
		 

	<div id="wrap">
		<div class="bg-color">
			<div class="box-white">
				<div class="logo-user"><a href="/"><img src="/assets/images/jupday_logo.png" alt="줍데이로고"></a></div>
				
				<form action="/member/memberJoin.do" onsubmit="return Validation();" method="post">
					<label for="userId" class="tit-label">아이디*</label><br>
					<input type="text" id="userId" class="input-style" name="userId" placeholder="아이디 입력 (8~12자)" maxlength="12"><br>
					<span id="msg" class="check-msg"></span><br>
				
					<label for="userPwd" class="tit-label">비밀번호*</label><br>
					<input type="password" id="userPwd" class="input-style" name="userPwd" onchange="pwCheck()" placeholder="비밀번호 입력 (영문, 숫자, 특수문자 조합 (8~16자))" maxlength="16"> <br>
					<input type="password" class="input-style" id="userPwdRe" name="userPwdRe" onchange="pwCheck()"  placeholder="비밀번호 확인">
					<span id="check" class="check-msg"></span><br>
					
					
					<label for="nick" class="tit-label">닉네임*</label><br>
					<input type="text" id="nick" class="input-style" name="nick" placeholder="닉네임 입력(영문, 숫자, 한글 조합으로 (8~16자))" ><br>
					<span id="nickCheck" class="check-msg"></span><br>
					
					<label for="email" class="tit-label">이메일*</label><br>
					<input type="email" id="email" class="input-style" name="email" placeholder="이메일"><br>
					<span id="emailCheck" class="check-msg"></span><br>
		
					<br>
					    	
		        	<h3 class="tit-join">이용 약관</h3>
		        	<div class="box-checkbox">
		        	    <input type="checkbox" name='jupday' value='terms1'  id="checkAgreement" onclick='checkSelectAll()'/><a href="">(필수) 개인정보 수집 이용동의</a><br>
			        	<input type="checkbox" name='jupday' value='terms2'  id="agreementCheck" onclick='checkSelectAll()'/><a href="">(필수) JUP:DAY 이용약관</a><br>
			        	<input type="checkbox" name='jupday' value='terms3'  onclick='checkSelectAll()'/><a href="">(선택) 마케팅 활용 및 광고성 정보 수신 동의</a><br>
		        	 	<input type="checkbox" name='selectall' value='selectall' onclick='selectAll(this)' id="checkAll"><label for=checkAll>약관 전체 동의</label><br>
		        	 </div>
					<input type="submit" class="btn-submit" value="가입하기">
				</form>
			</div>
		</div>
		
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
	
	<!-- jQuery 라이브러리 -->
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	
	<!-- ID 중복 체크 -->
	<script>
			
			$("#userId").blur(function() {
				var userId = $("#userId").val();
			    var getCheck= RegExp(/^[a-zA-Z0-9]{8,12}$/);
			   
				
			    if(!getCheck.test($("#userId").val())){
					$("#msg").html("ID는 8~12자의 영문 대소문자와 숫자로만 입력하여 주세요.").css("color","red");
			        return false;
			      }
				
				
				$.ajax({ 
					url: "/member/memberIdCheck.do",
					data: {"userId":userId},
					type: "get",
					success: function(result) {
						
						if(result=="true"){
							$("#msg").html("중복되는 아이디입니다. 다시 입력해주세요.").css("color","red");
							$("#userId").val('');
							return false;
						}else{
							$("#msg").html("사용 가능한 아이디입니다.").css("color","green");

						}
						
					},
					error: function() {
						console.log("ajax 통신 실패")
					}
				});
			});
	</script>
	
	
	<!-- nick 중복 체크 -->
	<script>
			
			$("#nick").blur(function() {
				var nick = $("#nick").val();
			    var n_RegExp= RegExp(/^[가-힣ㄱ-ㅎa-zA-Z0-9._-]{2,16}\$/);
			    
			    
		        if(!n_RegExp.test($("#nick").val())){ 
					$("#nickCheck").html("닉네임을 2~16자의 숫자,한글,영어,'_'로 입력해주세요.").css("color","red");
			        $("#nick").focus();
		            return false;
		        }


				
				$.ajax({ 
					url: "/member/memberNickCheck.do",
					data: {"nick": nick},
					type: "get",
					success: function(result) {
						
						if(result=="true"){
							$("#nickCheck").html("중복되는 닉네임입니다. 다시 입력해주세요.").css("color","red");
							$("#nick").val('');
							return false;
						}else{
							$("#nickCheck").html("사용 가능한 닉네임입니다.").css("color","green");

						}
						
					},
					error: function() {
						console.log("ajax 통신 실패")
					}
				});
			});
	</script>
	
	<!-- email 중복 체크 -->
	<script>
			
			$("#email").blur(function() {
				var email = $("#email").val();
			    var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
			    
			   
				
			    if(!getMail.test($("#email").val())){
					$("#emailCheck").html("올바른 이메일 형식이 아닙니다.").css("color","red");
			        return false;
			      }
				
				
				$.ajax({ 
					url: "/member/memberEmailCheck.do",
					data: {"email":email},
					type: "get",
					success: function(result) {
						
						if(result=="true"){
							$("#emailCheck").html("중복되는 이메일입니다. 다시 입력해주세요.").css("color","red");
							$("#email").val('');
							return false;
						}else{
							$("#emailCheck").html("사용 가능한 이메일입니다.").css("color","green");

						}
						
					},
					error: function() {
						console.log("ajax 통신 실패")
					}
				});
			});
	</script>

	
	
</body>
</html>
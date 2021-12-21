<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%
		Object result = request.getAttribute("idCheck");
	%>
	
	<!-- 아이디 정규화 -->
	<script>
		function checkId() {
			var userId = document.getElementById("userId").value;
			var exp = /^[a-zA-Z0-9]{8,12}$/; 
			if(exp.test(userId)){ 
				
				alert("중복 확인 중입니다. 잠시만 기다려주십시오.")
				
			}else{
				//중복되는 ID일때
				alert("잘못된 아이디 형식입니다. 영어와 숫자를 사용하여 8~12자로 다시작성해 주세요.");
			}
		}
	</script>

			 
	<!--result 값이 null이거나 servlet을 거치지 않고, 바로 해당 페이지가 열렸을 때 -->
	<%if(result==null){ %>
		<form action="/member/idCheck.do" method="get"  onsubmit="checkId();">
			<input type="text" id="userId" name="userId" placeholder="사용하실 ID를 입력하세요">
			<input type="submit" value="아이디 확인">			
		</form>		
		
	<!-- 값이 있거나 두번째 열렸을때 -->
	<%}else { %>
	
		<%String userId = (String)request.getAttribute("userId"); %>  
		 	
	   	<form action="/member/idCheck.do" method="get" onsubmit="idCheck();">
			<input type="text" id="checkId" name="userId" value="<%=userId%>" placeholder="사용하실 ID를 입력하세요">
			<input type="submit" value="아이디 확인">			
    	</form>	
	
		<!-- 중복되는 ID인 경우 사용자에게 알려주자 -->
		<%if((boolean)result){ %>
		
		    <%userId=null;%>
			<span style="color:red">중복된 아이디입니다. 다시 입력해 주세요.</span>		
			
			<script>
			 function idCheck() {
	            var checkId = document.getElementById("checkId").value;
	            var exp = /^[a-zA-Z0-9]{8,12}$/; 
	            if(exp.test(checkId)){
	            	
	                alert("중복 확인 중입니다. 잠시만 기다려주십시오.");
	                
	            }else{
	            	//중복되지 않지만 형식을 어긴 ID일때
	                alert("잘못된 아이디 형식입니다. 영어와 숫자를 사용하여 8~12자로 다시 작성해 주세요.");
				    window.close();
	            }
	        }	 
	       </script>		
					
    	<!--중복되지 않는 ID인 경우 -->		
		<%}else { %>	
     	
	     	<span style="color:black">중복되지 않는 아이디입니다.</span>		
	     								
			<script>
			function idCheck() {
	            var checkId = document.getElementById("checkId").value;
	            var exp = /^[a-zA-Z0-9]{8,12}$/; 
	            if(exp.test(checkId)){
	            	//증복되지도 않고 정규화 검증도 끝낸 ID 처리 로직
	                alert("사용 가능한 아이디 입니다.");
	                window.opener.document.getElementById('userId').value= document.getElementById("checkId").value;
				    window.close();
	                
	            }else{
	            	//중복되지않지만 형식을 어긴 ID일때
	                alert("잘못된 아이디 형식입니다. 영어와 숫자를 사용하여 8~12자로 다시 작성해 주세요.");
				    window.close();
	            }
	        }
	     	</script>		
		<%} %>
	<%} %>
</body>
</html>
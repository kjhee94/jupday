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
	Object result = request.getAttribute("emailCheck");
	%>
	
	<!-- result 값이 null이거나 혹은 있거나, null이면 Servlet을 거치지 않고 바로 해당 페이지가 열렸을때 -->
	<%if(result==null){ %>
	
		<form action="/member/emailCheck.do" method="get">
			<input type="text" name="email" placeholder="중복 확인할 이메일을 입력하세요"/>
			<input type="submit" value="중복확인"/>
		</form>
		
	<!-- null이 아닐때 -->
	<%}else{%>
	
		<%String email=(String)request.getAttribute("email"); %>
		
	 	<form action="/member/emailCheck.do" method="get">
			<input type="text" id="email1"  name="email" value="<%=email%>" placeholder="중복 확인할 이메일을 입력하세요"/>
			<input type="submit" value="중복확인"/>
		</form>
	
	    <%if((boolean)result){%>
	       <span style = "color:red;">해당 이메일은 이미 사용 중 입니다</span>
	       
	    <%}else{%>
		    <span style = "color:blue">해당 이메일을 사용 가능합니다</span><br>
		    <button onclick="useEmail();">사용하기</button>
	        	
		    <script>
		  	function useEmail()
		  	{      		
		  		window.opener.document.getElementById('email').value=document.getElementById("email1").value;
		  		window.close();
		  	}    	
		  	</script>
	  	<%} %>    
	  		
	<%} %>

</body>
</html>